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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author danghuy1708
 */
@Controller
@RequestMapping("/guest")
public class GuestController {
    
    @Autowired
    private VaccineService vaccineService;
    
    @GetMapping("/home")
    public String guest() {
        return "/guest";
    }
    
    @GetMapping("/list/{page}")
    public String getList(@PathVariable(name = "page") int page, Model model) {
        String url = "/guest/list";
        int count = 5;
        int countMax = vaccineService.countList();
        int pageMax = (int) Math.ceil((double)countMax / count);
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
        return url;
    }
}
