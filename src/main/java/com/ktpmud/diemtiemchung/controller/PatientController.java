/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.controller;

import com.ktpmud.diemtiemchung.entity.Patient;
import com.ktpmud.diemtiemchung.model.dto.PatientDTO;
import com.ktpmud.diemtiemchung.model.dto.VaccineDTO;
import com.ktpmud.diemtiemchung.service.Patient.PatientService;
import com.ktpmud.diemtiemchung.service.vaccine.VaccineService;
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
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private VaccineService vaccineService;

    @GetMapping("/register/{page}")
    public String getPatient(@PathVariable("page") int page, Model model) {
        PatientDTO pa = new PatientDTO();
        model.addAttribute("acc", pa);
        int count = 5;
        int countMax = vaccineService.countList();
        int pageMax = (int) Math.ceil((double) countMax / count);
        if (page < 1) {
            page = 1;
        }
        if (page * count > countMax) {
            page = pageMax;
        }

        List<VaccineDTO> list = vaccineService.getList((page - 1) * count + 1, count);
        model.addAttribute("list", list);
        model.addAttribute("pageNumber", page);
        model.addAttribute("pageMax", pageMax);
        return "/guest/vaccine_register";
    }

    @PostMapping("/register/save")
    public String savePatient(@ModelAttribute("acc") PatientDTO pa, Model model) {
        PatientDTO tmp = patientService.savePatient(pa);
        if (tmp == null) {
            tmp = new PatientDTO("N/A", "N/A", "N/A", "N/A", "N/A", "N/A");
        }
        model.addAttribute("patient", tmp);

        return "/guest/viewPatient";
    }

    @GetMapping("/home")
    public String home() {
        return "/manager/patient/index";
    }

    @GetMapping("/list/{pageNumber}")
    public String getList(@PathVariable(name = "pageNumber") int page, Model model) {
        int count = 5;
        int countMax = patientService.countMax();
        int pageMax = (int) Math.ceil((double) countMax / count);
        if (page < 1) {
            page = 1;
        }
        if (page > pageMax) {
            page = pageMax;
        }
        List<Patient> list = patientService.getList((page - 1) * count, count);
        model.addAttribute("pageNumber", page);
        model.addAttribute("pageMax", pageMax);
        model.addAttribute("list", list);
        return "/manager/patient/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Patient pa = patientService.getPatientById(id);
        model.addAttribute("patient", pa);
        return "/manager/patient/viewDetail";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("patient") Patient pa, Model model) {
        String msg = "Cập nhật thành công";
        Patient tmp = patientService.update(pa);
        model.addAttribute("msg", msg);
        model.addAttribute("patient", tmp);
        return "/manager/patient/viewDetail";
    }

    @GetMapping("/search1")
    public String toSearchCccd() {
        return "/manager/patient/searchByCccd";
    }

    @GetMapping("/search2")
    public String toSearchName() {
        return "/manager/patient/searchByName";
    }

    @GetMapping("/searchcccd")
    public String searchCccd(@RequestParam("cccd") String cccd, Model model) {
        if (cccd != null) {
            List<Patient> list = patientService.getListCccd(cccd);
            model.addAttribute("list", list);
        }
        return "/manager/patient/searchByCccd";
    }

    @GetMapping("/searchname")
    public String searchName(@RequestParam("name") String name, Model model) {
        if (name != null) {
            List<Patient> list = patientService.getListName(name);
            model.addAttribute("list", list);
        }
        return "/manager/patient/searchByName";
    }
    
    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") String id, Model model) {
        int count = 5;
        if (patientService.deletePatient(id)) {
            model.addAttribute("msg", "Xóa khách hàng thành công");
        } else {
            model.addAttribute("msg", "Xóa khách hàng thất bại");
        }
        int page = 1;
        int countMax = patientService.countMax();
        int pageMax = (int) Math.ceil((double) countMax / count);
        if (page < 1) {
            page = 1;
        }
        if (page > pageMax) {
            page = pageMax;
        }
        List<Patient> list = patientService.getList((page - 1) * count, count);
        model.addAttribute("pageNumber", page);
        model.addAttribute("pageMax", pageMax);
        model.addAttribute("list", list);
        return "/manager/patient/list";
    }
}
