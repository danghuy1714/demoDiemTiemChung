/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.service.vaccine;

import com.ktpmud.diemtiemchung.entity.Vaccine;
import com.ktpmud.diemtiemchung.model.dto.VaccineDTO;
import com.ktpmud.diemtiemchung.model.mapper.VaccineMapper;
import com.ktpmud.diemtiemchung.repository.VaccineRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

/**
 *
 * @author danghuy1708
 */
@Component
public class VaccineServiceImple implements VaccineService {
    
    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public List<VaccineDTO> getList(int page, int count) {
        List<VaccineDTO> list = new ArrayList<>();
        List<Vaccine> ref = (List<Vaccine>) vaccineRepository.findAll();
        int i = 1;
        for (Vaccine va : ref) {
            if (i >= page) {
                list.add(VaccineMapper.toDTO(va));
                --count;
            }
            if (count == 0) {
                break;
            }
            ++i;
        }
        return list;
    }

    @Override
    public int countList() {
        List<Vaccine> list = (List<Vaccine>) vaccineRepository.findAll();
        return list.size();
    }

    @Override
    public VaccineDTO saveVaccine(VaccineDTO vac) {
        if (!vac.fullAttribute()) {
            return null;
        }
        List<Vaccine> list = (List<Vaccine>) vaccineRepository.findAll();
        String[] t = list.get(list.size() - 1).getMaSoThuoc().split("ID");
        Vaccine new_va = new Vaccine();
        new_va.setMaSoThuoc("ID" + Integer.toString(Integer.parseInt(t[1]) + 1));
        new_va.setTenThuoc(vac.getTenThuoc());
        new_va.setSoLuong(vac.getSoLuong());
        new_va.setSoMuiCanTiem(vac.getSoMuiCanTiem());
        new_va.setSoNgayTiemMuiTiep(vac.getSoNgayTiemMuiTiep());
        new_va.setDonGia(vac.getDonGia());
        return VaccineMapper.toDTO(vaccineRepository.save(new_va));
    }

    @Override
    public VaccineDTO getVaccineById(String id) {
        Optional<Vaccine> op = vaccineRepository.findById(id);
        return VaccineMapper.toDTO(op.get());
    }

    @Override
    public VaccineDTO updateVaccine(VaccineDTO va) {
        Optional<Vaccine> op = vaccineRepository.findById(va.getMaSoThuoc());
        Vaccine vaccine = op.get();
        if (!va.getTenThuoc().isEmpty()) {
            vaccine.setTenThuoc(va.getTenThuoc());
        }
        if (va.getSoLuong() != 0) {
            vaccine.setSoLuong(va.getSoLuong());
        }
        if (va.getSoMuiCanTiem() != 0) {
            vaccine.setSoMuiCanTiem(va.getSoMuiCanTiem());
        }
        if (va.getSoNgayTiemMuiTiep() != 0) {
            vaccine.setSoNgayTiemMuiTiep(va.getSoNgayTiemMuiTiep());
        }
        if (va.getDonGia() != 0) {
            vaccine.setDonGia(va.getDonGia());
        }
        vaccineRepository.save(vaccine);
        return VaccineMapper.toDTO(vaccine);
    }

    @Override
    public boolean deleteVaccine(String id) {
        try {
            vaccineRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
}
