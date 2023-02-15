/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.model.mapper;

import com.ktpmud.diemtiemchung.entity.Patient;
import com.ktpmud.diemtiemchung.model.dto.PatientDTO;

/**
 *
 * @author danghuy1708
 */
public class PatientMapper {

    public static PatientDTO toDTO(Patient pa) {
        PatientDTO tmp = new PatientDTO();
        tmp.setHoTen(pa.getHoTen());
        tmp.setCccd(pa.getCccd());
        String date = Integer.toString(pa.getNgaySinh().getYear()) + "-" + Integer.toString(pa.getNgaySinh().getMonth()) + "-"
                + Integer.toString(pa.getNgaySinh().getDay());
        tmp.setNgaySinh(date);
        tmp.setSdt(pa.getSdt());
        tmp.setGioiTinh(pa.getGioiTinh());
        tmp.setEmail(pa.getEmail());
        return tmp;
    }
}
