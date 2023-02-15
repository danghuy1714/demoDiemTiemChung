/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.model.dto;

import java.util.Date;
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
public final class PatientDTO {
    private String hoTen;
    private String cccd;
    private String ngaySinh;
    private String sdt;
    private String gioiTinh;
    private String email;    
}
