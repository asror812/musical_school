package com.example.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.example.school.dto.DashboardInfo;
import com.example.school.service.AdminService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/dashboard")
    public ModelAndView getAdminPage() {
        ModelAndView modelAndView = new ModelAndView("admin/index");
        DashboardInfo dashboardInfo = adminService.getDashboardInfo();
        modelAndView.addObject("dashboard", dashboardInfo);

        return modelAndView;
    }

}
