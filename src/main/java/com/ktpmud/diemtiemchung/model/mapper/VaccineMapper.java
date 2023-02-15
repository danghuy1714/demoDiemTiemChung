/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.model.mapper;

import com.ktpmud.diemtiemchung.entity.Vaccine;
import com.ktpmud.diemtiemchung.model.dto.VaccineDTO;

/**
 *
 * @author danghuy1708
 */
public class VaccineMapper {
    public static VaccineDTO toDTO(Vaccine vaccine) {
        VaccineDTO tmp = new VaccineDTO();
        tmp.setMaSoThuoc(vaccine.getMaSoThuoc());
        tmp.setTenThuoc(vaccine.getTenThuoc());
        tmp.setSoLuong(vaccine.getSoLuong());
        tmp.setSoMuiCanTiem(vaccine.getSoMuiCanTiem());
        tmp.setSoNgayTiemMuiTiep(vaccine.getSoNgayTiemMuiTiep());
        tmp.setDonGia(vaccine.getDonGia());
        return tmp;
    }
    public static Vaccine toVaccine(VaccineDTO vaccine) {
        Vaccine tmp = new Vaccine();
        tmp.setMaSoThuoc(vaccine.getMaSoThuoc());
        tmp.setTenThuoc(vaccine.getTenThuoc());
        tmp.setSoLuong(vaccine.getSoLuong());
        tmp.setSoMuiCanTiem(vaccine.getSoMuiCanTiem());
        tmp.setSoNgayTiemMuiTiep(vaccine.getSoNgayTiemMuiTiep());
        tmp.setDonGia(vaccine.getDonGia());
        return tmp;
    }
}
