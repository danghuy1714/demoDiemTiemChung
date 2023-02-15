/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.service.vaccine;

import com.ktpmud.diemtiemchung.model.dto.VaccineDTO;
import java.util.List;

/**
 *
 * @author danghuy1708
 */
public interface VaccineService {
    public List<VaccineDTO> getList(int page, int count);
    public int countList();
    public VaccineDTO saveVaccine(VaccineDTO va);
    public VaccineDTO getVaccineById(String id);
    public VaccineDTO updateVaccine(VaccineDTO va);
    public boolean deleteVaccine(String id);
}
