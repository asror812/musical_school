package com.example.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.school.dto.request.PupilCreateDTO;
import com.example.school.dto.request.TeacherCreateDTO;
import com.example.school.dto.response.PupilResponseDTO;
import com.example.school.dto.response.TeacherResponseDTO;
import com.example.school.service.PupilService;
import com.example.school.service.TeacherService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final TeacherService teacherService;
    private final PupilService pupilService;

    @PostMapping("/teachers")
    public ResponseEntity<TeacherResponseDTO> register(@Valid @ModelAttribute TeacherCreateDTO createDTO) {
        return new ResponseEntity<>(teacherService.register(createDTO), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ModelAndView getSignInPage() {
        return new ModelAndView("login");
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute PupilCreateDTO createDTO) {
        ModelAndView modelAndView = new ModelAndView("pupil/pupil-profile");
        PupilResponseDTO register = pupilService.register(createDTO);

        modelAndView.addObject("pupil",  register);
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView gerRegisterPage(){
        return new  ModelAndView("register");
    }
}
