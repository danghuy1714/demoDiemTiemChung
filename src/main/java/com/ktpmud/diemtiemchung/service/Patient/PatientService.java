/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.service.Patient;

import com.ktpmud.diemtiemchung.entity.Patient;
import com.ktpmud.diemtiemchung.model.dto.PatientDTO;
import java.util.List;

/**
 *
 * @author danghuy1708
 */
public interface PatientService {
    public List<Patient> getList(int page, int count);
    public int countMax();
    public PatientDTO savePatient(PatientDTO pa);
    public Patient getPatientById(String id);
    public Patient update(Patient pa);
    public List<Patient> getListCccd(String cccd);
    public List<Patient> getListName(String name);
    public boolean deletePatient(String id);
}
