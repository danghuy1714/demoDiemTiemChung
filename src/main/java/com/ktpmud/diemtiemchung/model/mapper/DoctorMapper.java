/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.model.mapper;

import com.ktpmud.diemtiemchung.entity.Doctor;
import com.ktpmud.diemtiemchung.model.dto.DoctorDTO;

/**
 *
 * @author danghuy1708
 */
public class DoctorMapper {
    public static Doctor dtoToDoctor(DoctorDTO d) {
        Doctor n = new Doctor();
        n.setChucDanh(d.getChucDanh());
        n.setSdt(d.getSdt());
        n.setTenBacSi(d.getTenBacSi());
        n.setTuoi(d.getTuoi());
        n.setMaDinhDanh("0");
        return n;
    }
    public static DoctorDTO toDTO(Doctor doctor) {
        DoctorDTO tmp = new DoctorDTO();
        tmp.setChucDanh(doctor.getChucDanh());
        tmp.setSdt(doctor.getSdt());
        tmp.setTenBacSi(doctor.getTenBacSi());
        tmp.setTuoi(doctor.getTuoi());
        return tmp;
    }
}
