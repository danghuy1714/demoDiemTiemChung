/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.controller;

import com.ktpmud.diemtiemchung.entity.Doctor;
import com.ktpmud.diemtiemchung.model.dto.DoctorDTO;
import com.ktpmud.diemtiemchung.model.dto.VaccineDTO;
import com.ktpmud.diemtiemchung.service.DoctorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author danghuy1708
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/home")
    public String home() {
        return "/manager/doctor/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        DoctorDTO doctor = new DoctorDTO();
        model.addAttribute("doctor", doctor);
        return "/manager/doctor/create";
    }

    @PostMapping("/create")
    public String createNew(@ModelAttribute("doctor") DoctorDTO doctor, Model model) {
        String msg = "Thêm bác sĩ thành công";
        Doctor d = new Doctor();

        d = doctorService.save(doctor);
        if (d == null) {
            msg = "Thêm bác sĩ thất bại. Vui lòng nhập đủ thông tin.";
            d = new Doctor();
        }

        model.addAttribute("doctor", d);
        model.addAttribute("msg", msg);
        return "/manager/doctor/create";
    }
    
    @GetMapping("/list/{page}")
    public String getList(@PathVariable(name = "page") int page, Model model) {
        int count = 5;
        int countMax = doctorService.countMax();
        int pageMax = (int) Math.ceil((double) countMax / count);
        if (page < 1) {
            page = 1;
        }
        if (page > pageMax) {
            page = pageMax;
        }
        List<Doctor> list = doctorService.getList((page - 1) * count, count);
        model.addAttribute("pageNumber", page);
        model.addAttribute("pageMax", pageMax);
        model.addAttribute("list", list);
        return "/manager/doctor/list";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Doctor d = doctorService.getDoctor(id);
        model.addAttribute("doctor", d);
        return "/manager/doctor/viewDetail";
    }
    
    @PostMapping("/edit")
    public String update(@ModelAttribute("doctor") Doctor doctor, Model model) {
        String msg = "Thay đổi thông tin bác sĩ thành công";
        Doctor d = doctorService.update(doctor);
        model.addAttribute("msg", msg);
        model.addAttribute("doctor", d);
        return "/manager/doctor/viewDetail";
    }
    
    @GetMapping("/searchinfo")
    public String homeSearch() {
        return "/manager/doctor/search";
    }
    
    @GetMapping("/search")
    public String search(@RequestParam("info") String info, @RequestParam("chucDanh") String chucDanh, Model model) {
        if (info != null) {
            List<Doctor> list = doctorService.search(info, chucDanh);
            model.addAttribute("list", list);
        }
        return "/manager/doctor/search";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        int page = 1;
        if (doctorService.deleteDoctor(id)) {
            model.addAttribute("msg", "Xóa bác sĩ thành công");
        } else {
            model.addAttribute("msg", "Xóa bác sĩ thất bại");
        }
        
        int count = 5;
        int countMax = doctorService.countMax();
        int pageMax = (int) Math.ceil((double) countMax / count);
        if (page < 1) {
            page = 1;
        }
        if (page > pageMax) {
            page = pageMax;
        }
        List<Doctor> list = doctorService.getList((page - 1) * count, count);
        model.addAttribute("pageNumber", page);
        model.addAttribute("pageMax", pageMax);
        model.addAttribute("list", list);
        return "/manager/doctor/list";
    }
}
