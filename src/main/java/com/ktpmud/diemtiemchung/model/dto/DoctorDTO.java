 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author danghuy1708
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorDTO {
    private String tenBacSi;
    private Integer tuoi;
    private String chucDanh;
    private String sdt;
    
    public boolean fullAttribute() {
        if (tenBacSi.isEmpty() || tuoi == null || sdt.isEmpty()) {
            return false;
        }
        return true;
    }
}
