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
@Table(name = "bacsi")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @Column(name = "madinhdanh")
    private String maDinhDanh;
    
    @Column(name = "tenbacsi")
    private String tenBacSi;
    
    @Column(name = "tuoi")
    private Integer tuoi;
    
    @Column(name = "chucdanh")
    private String chucDanh;
    
    @Column(name = "sdt")
    private String sdt;
    
}
