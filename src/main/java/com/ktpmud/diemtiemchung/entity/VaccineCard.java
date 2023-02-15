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
@Table(name = "phieutiem")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VaccineCard {
    @Id
    @Column(name = "ID_phieutiem", nullable = false, length = 20)
    private String idPhieuTiem;
    
    @Column(name = "ID_benh_nhan", length = 20, nullable = false)
    private String idBenhNhan;
    
    @Column(name = "madinhdanh", length = 20, nullable = false)
    private String maDinhDanh;
    
    @Column(name = "masothuoc", length = 20, nullable = false)
    private String maSoThuoc;
    
    @Column(name = "somuidatiem", nullable = false)
    private Integer soMuiDaTiem;
    
    @Column(name = "ngaydatiem")
    private Date ngayDaTiem;
    
    @Column(name = "ngaytiem", nullable = false)
    private Date ngayTiem;
}
