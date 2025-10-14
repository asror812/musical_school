package com.example.school.controller;

import java.util.UUID;

import org.springframework.web.servlet.ModelAndView;

import com.example.school.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("user/index");
        modelAndView.addObject("users", userService.getAll());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getById(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("user/user-profile");
        modelAndView.addObject("user", userService.getById(UUID.fromString(id)));
        return modelAndView;
    }

}
