/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.service;

import com.ktpmud.diemtiemchung.entity.Doctor;
import com.ktpmud.diemtiemchung.model.dto.DoctorDTO;
import java.util.List;

/**
 *
 * @author danghuy1708
 */
public interface DoctorService {
    public Doctor save(DoctorDTO doctor);
    public List<Doctor> getList(int page, int count);
    public int countMax();
    public Doctor getDoctor(String id);
    public Doctor update(Doctor doctor);
    public List<Doctor> search(String info, String chucDanh);
    public boolean deleteDoctor(String id);
}
