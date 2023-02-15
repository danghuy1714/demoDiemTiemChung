/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "thuoctiem")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vaccine {

    @Id
    @Column(name = "masothuoc", length = 20, nullable = false)
    private String maSoThuoc;

    @Column(name = "tenthuoc", length = 20, nullable = false)
    private String tenThuoc;

    @Column(name = "soluong", nullable = false)
    private Float soLuong;

    @Column(name = "somuicantiem", nullable = false)
    private Integer soMuiCanTiem;

    @Column(name = "songaytiemmuitiep", nullable = true)
    private Integer soNgayTiemMuiTiep;

    @Column(name = "dongia", nullable = false)
    private Float donGia;
}
