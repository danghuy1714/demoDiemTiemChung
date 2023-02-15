/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author danghuy1708
 */
@Entity
@Table(name = "benhnhan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient {
    @Id
    @Column(name = "ID_benh_nhan", length = 20, nullable = false)
    private String idBenhNhan;
    
    @Column(name = "hoten", length = 20, nullable = false)
    private String hoTen;
    
    @Column(name = "cccd", length = 20, nullable = false)
    private String cccd;
    
    @Column(name = "ngaysinh", nullable = false)
    private Date ngaySinh;
    
    @Column(name = "sdt", length = 20, nullable = false)
    private String sdt;
    
    @Column(name = "gioitinh", length = 5, nullable = false)
    private String gioiTinh;
    
    @Column(name = "email", length = 30)
    private String email;
}
