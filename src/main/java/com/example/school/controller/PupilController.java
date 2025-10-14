package com.example.school.controller;

import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.school.service.PupilService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pupils")
public class PupilController {
    private final PupilService pupilService;

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("pupil/index");
        modelAndView.addObject("pupils", pupilService.getAll());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getById(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("pupil/pupil-profile");
        modelAndView.addObject("pupil", pupilService.getById(UUID.fromString(id)));
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable String id) {
        pupilService.deleteById(UUID.fromString(id));
        return new ModelAndView("redirect:/pupils");
    }



}
