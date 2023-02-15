/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.service.Patient;

import com.ktpmud.diemtiemchung.entity.Patient;
import com.ktpmud.diemtiemchung.model.dto.PatientDTO;
import com.ktpmud.diemtiemchung.model.mapper.PatientMapper;
import com.ktpmud.diemtiemchung.repository.PatientRepository;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author danghuy1708
 */
@Component
public class PatientServiceImple implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientDTO savePatient(PatientDTO pa) {
        if (pa.getCccd().isEmpty()) {
            return null;
        }
        Patient re = null;
        List<Patient> list = (List<Patient>) patientRepository.findAll();
        int i = 0;
        Patient p = null;
        for (i = 0; i < list.size(); ++i) {
            p = list.get(i);
            if (pa.getCccd().equals(p.getCccd())) {
                re = new Patient();
                re.setIdBenhNhan(p.getIdBenhNhan());
                re.setHoTen(p.getHoTen());
                re.setCccd(p.getCccd());
                re.setNgaySinh(p.getNgaySinh());
                re.setSdt(p.getSdt());
                re.setGioiTinh(p.getGioiTinh());
                re.setEmail(p.getEmail());
            }
        }
        if (re != null) {
            System.out.println(re.toString());
            return PatientMapper.toDTO(re);
        }
        if (pa.getEmail().isEmpty() || pa.getGioiTinh().isEmpty() || pa.getHoTen().isEmpty() || pa.getSdt().isEmpty() || pa.getNgaySinh().isEmpty()) {
            return null;
        }
        String[] id = null;
        if (p == null) {
            id[0] = "";
            id[1] = "00";
        } else {
            id = p.getIdBenhNhan().split("BN");
        }
        re = new Patient();
        re.setIdBenhNhan("BN" + (Integer.parseInt(id[1]) + 1));
        re.setHoTen(pa.getHoTen());
        re.setCccd(pa.getCccd());
        String[] l = pa.getNgaySinh().split("-");
        Date date = new Date(Integer.parseInt(l[0]), Integer.parseInt(l[1]), Integer.parseInt(l[2]));
        re.setNgaySinh(date);
        re.setSdt(pa.getSdt());
        re.setGioiTinh(pa.getGioiTinh());
        re.setEmail(pa.getEmail());
        System.out.println(re.toString());
        return PatientMapper.toDTO(patientRepository.save(re));
    }

    @Override
    public List<Patient> getList(int page, int count) {
        List<Patient> list = (List<Patient>) patientRepository.findAll();
        List<Patient> re = new ArrayList<>();
        int i = 0;
        for (Patient pa : list) {
            if (i >= page) {
                re.add(pa);
                --count;
            }
            if (count == 0) {
                break;
            }
            ++i;
        }
        return re;
    }

    @Override
    public int countMax() {
        List<Patient> list = (List<Patient>) patientRepository.findAll();
        return list.size();
    }

    @Override
    public Patient getPatientById(String id) {
        Optional<Patient> op = patientRepository.findById(id);
        return op.get();
    }

    @Override
    public Patient update(Patient pa) {
        Optional<Patient> op = patientRepository.findById(pa.getIdBenhNhan());
        Patient tmp = op.get();
        tmp.setHoTen(pa.getHoTen());
        tmp.setEmail(pa.getEmail());
        tmp.setGioiTinh(pa.getGioiTinh());
        tmp.setNgaySinh(pa.getNgaySinh());
        tmp.setSdt(pa.getSdt());
        return patientRepository.save(tmp);
    }

    @Override
    public List<Patient> getListCccd(String cccd) {
        List<Patient> list = new ArrayList<>();
        List<Patient> op = (List<Patient>) patientRepository.findAll();
        for (Patient pa : op) {
            if (pa.getCccd().equals(cccd)) {
                list.add(pa);
            }
        }
        return list;
    }

    @Override
    public List<Patient> getListName(String name) {
        List<Patient> list = (List<Patient>) patientRepository.findAll();
        List<Patient> re = new ArrayList<>();
        for (Patient pa : list) {
            if (pa.getHoTen().contains(name)) {
                re.add(pa);
            }
        }
        if (re.isEmpty()) {
            return null;
        }
        return re;
    }

    @Override
    public boolean deletePatient(String id) {
        try {
            patientRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
