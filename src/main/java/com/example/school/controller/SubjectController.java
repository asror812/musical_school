package com.example.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.school.dto.request.SubjectCreateDTO;
import com.example.school.dto.request.SubjectUpdateDTO;
import com.example.school.dto.response.SubjectResponseDTO;
import com.example.school.service.SubjectService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping
    public ModelAndView create(@Valid @ModelAttribute SubjectCreateDTO createDTO) {
        subjectService.create(createDTO);
        return new ModelAndView("redirect:/subjects");
    }

    @GetMapping("/{id}")
    public ModelAndView getById(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("subject/subject-details");
        SubjectResponseDTO subject = subjectService.getById(Long.valueOf(id));
        modelAndView.addObject("subject", subject);

        return modelAndView;
    }

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("subject/index");
        modelAndView.addObject("subjects", subjectService.getAll());
        return modelAndView;
    }

    @PutMapping("/{id}")
    public ModelAndView update(@PathVariable String id,
                               @Valid @ModelAttribute SubjectUpdateDTO updateDTO) {
        ModelAndView modelAndView = new ModelAndView("subject/subject-details");
        SubjectResponseDTO responseDTO = subjectService.update(Long.valueOf(id), updateDTO);
        modelAndView.addObject("subject", responseDTO);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreatePage() {
        return new ModelAndView("subject/create");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable String id) {
        subjectService.deleteById(Long.valueOf(id));
        return new ModelAndView("redirect:/subjects");
    }

}
