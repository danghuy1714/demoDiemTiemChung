/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.repository;

import com.ktpmud.diemtiemchung.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danghuy1708
 */
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, String> {
    
}
