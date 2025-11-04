package com.example.school.controller;

import com.example.school.dto.request.LessonCreateDTO;
import com.example.school.dto.request.LessonUpdateDTO;
import com.example.school.dto.response.LessonResponseDTO;
import com.example.school.model.enums.Day;
import com.example.school.service.LessonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.EnumMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {
    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<LessonResponseDTO> create(@Valid @RequestBody LessonCreateDTO createDTO) {
        return new ResponseEntity<>(lessonService.create(createDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ModelAndView getById(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("lesson/lesson-details");
        modelAndView.addObject("lesson", lessonService.getById(Long.parseLong(id)));
        return modelAndView;
    }

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("lesson/index");

        EnumMap<Day, List<LessonResponseDTO>> lessonsByDay = lessonService.getScheduleByDay();
        modelAndView.addObject("lessons", lessonsByDay);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView update(@PathVariable String id, @Valid @RequestBody LessonUpdateDTO updateDTO) {
        lessonService.update(Long.valueOf(id), updateDTO);
        return new ModelAndView("redirect:/lessons");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable String id) {
        lessonService.deleteById(Long.valueOf(id));
        return new ModelAndView("redirect:/lessons");
    }
}
