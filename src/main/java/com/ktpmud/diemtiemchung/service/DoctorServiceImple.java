/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.service;

import com.ktpmud.diemtiemchung.entity.Doctor;
import com.ktpmud.diemtiemchung.model.dto.DoctorDTO;
import com.ktpmud.diemtiemchung.repository.DoctorRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author danghuy1708
 */
@Component
public class DoctorServiceImple implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor save(DoctorDTO doctor) {
        if (doctor.fullAttribute()) {
            List<Doctor> list = (List<Doctor>) doctorRepository.findAll();
            String id = "BS1";
            if (!list.isEmpty()) {
                id = "BS" + Integer.toString(Integer.parseInt(list.get(list.size() - 1).getMaDinhDanh().split("BS")[1]) + 1);
            }
            Doctor tmp = new Doctor();
            tmp.setMaDinhDanh(id);
            tmp.setChucDanh(doctor.getChucDanh());
            tmp.setSdt(doctor.getSdt());
            tmp.setTenBacSi(doctor.getTenBacSi());
            tmp.setTuoi(doctor.getTuoi());
            return doctorRepository.save(tmp);
        }
        return null;
    }

    @Override
    public List<Doctor> getList(int page, int count) {
        List<Doctor> list = (List<Doctor>) doctorRepository.findAll();
        List<Doctor> re = new ArrayList<>();
        int i = 0;
        for (Doctor d : list) {
            if (i >= page) {
                re.add(d);
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
        List<Doctor> list = (List<Doctor>) doctorRepository.findAll();
        return list.size();
    }

    @Override
    public Doctor getDoctor(String id) {
        Optional<Doctor> op = doctorRepository.findById(id);
        return op.get();
    }

    @Override
    public Doctor update(Doctor doctor) {
        Optional<Doctor> op = doctorRepository.findById(doctor.getMaDinhDanh());
        Doctor tmp = op.get();
        tmp.setMaDinhDanh(doctor.getMaDinhDanh());
        tmp.setChucDanh(doctor.getChucDanh());
        tmp.setSdt(doctor.getSdt());
        tmp.setTenBacSi(doctor.getTenBacSi());
        tmp.setTuoi(doctor.getTuoi());
        return doctorRepository.save(tmp);
    }

    @Override
    public List<Doctor> search(String info, String chucDanh) {
        List<Doctor> re = new ArrayList<>();
        List<Doctor> list = (List<Doctor>) doctorRepository.findAll();
        if (info != null) {
            if (info.contains("BS")) {
                for (Doctor d : list) {
                    if (d.getMaDinhDanh().contains(info) && chucDanh.equals(d.getChucDanh())) {
                        re.add(d);
                    }
                }
            } else {
                for (Doctor d : list) {
                    if (d.getTenBacSi().contains(info) && chucDanh.equals(d.getChucDanh())) {
                        re.add(d);
                    }
                }
            }
        }
        return re;
    }

    @Override
    public boolean deleteDoctor(String id) {
        try {
            doctorRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
