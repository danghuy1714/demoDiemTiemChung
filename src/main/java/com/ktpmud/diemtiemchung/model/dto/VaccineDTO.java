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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VaccineDTO {
    private String maSoThuoc;
    private String tenThuoc;
    private Float soLuong;
    private Integer soMuiCanTiem;
    private Integer soNgayTiemMuiTiep;
    private Float donGia;
    
    public boolean fullAttribute() {
        if (tenThuoc == null | soLuong == null 
                || soMuiCanTiem == null || soNgayTiemMuiTiep == null || donGia == null) {
            return false;
        }
        return true;
    }
}
