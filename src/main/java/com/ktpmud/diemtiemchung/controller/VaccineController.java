/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ktpmud.diemtiemchung.controller;

import com.ktpmud.diemtiemchung.model.dto.VaccineDTO;
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

/**
 *
 * @author danghuy1708
 */
@Controller
@RequestMapping("/vaccine")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @GetMapping("/home")
    public String index() {
        return "/manager/vaccine/index";
    }

    @GetMapping("/create")
    public String index(Model model) {
        VaccineDTO vac = new VaccineDTO();
        model.addAttribute("vaccine", vac);
        return "/manager/vaccine/create";
    }

    @PostMapping("/create")
    public String getViewDetail(@ModelAttribute("vaccine") VaccineDTO vacc, Model model) {
        String msg = "Thêm thuốc tiêm thành công";
        String url = "/manager/vaccine/viewDetail";
        VaccineDTO vac = vaccineService.saveVaccine(vacc);
        if (vac == null) {
            msg = "Thêm thuốc tiêm thất bại, vui lòng nhập đầy đủ thông tin";
            url = "/manager/vaccine/create";
        }
        model.addAttribute("msg", msg);
//        model.addAttribute("vaccine", vac);
        return url;
    }

    @GetMapping("/list/{pageNumber}")
    public String getList(@PathVariable("pageNumber") int page, Model model) {
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
        return "/manager/vaccine/list";
    }

    @GetMapping("/edit/{id}")
    public String editVaccine(@PathVariable("id") String id, Model model) {
        VaccineDTO vacc = vaccineService.getVaccineById(id);
        model.addAttribute("vaccine", vacc);
        return "/manager/vaccine/viewDetail";
    }

    @GetMapping("/edit")
    public String update(VaccineDTO vacc, Model model, String msga) {
        String msg = "Thay đổi thông tin thuốc tiêm";
        if (msga != null) {
            msg = msga;
        }
        model.addAttribute("vaccine", vacc);
        model.addAttribute("msg", msg);
        return "/manager/vaccine/viewDetail";
    }

    @PostMapping("/edit")
    public String saveEdit(@ModelAttribute("vaccine") VaccineDTO vaccine, Model model) {
        System.out.println(vaccine.getMaSoThuoc());
        VaccineDTO v = vaccineService.updateVaccine(vaccine);
        return this.update(v, model, "Thay đổi thành công");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        int page = 1;
        if (vaccineService.deleteVaccine(id)) {
            model.addAttribute("msg", "Xóa thuốc tiêm thành công");
        } else {
            model.addAttribute("msg", "Xóa thuốc tiêm thất bại");
        }
        
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
        return "/manager/vaccine/list";
    }
}
