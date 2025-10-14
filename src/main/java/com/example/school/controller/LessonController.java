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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        List<LessonResponseDTO> lessons = lessonService.getAll();
        Map<String, List<LessonResponseDTO>> lessonsByDay = Arrays.stream(Day.values()).collect(Collectors.toMap(Enum::name, day -> lessons.stream().filter(lesson -> lesson.getDayOfWeek() == day).collect(Collectors.toList())));


        for (Map.Entry<String, List<LessonResponseDTO>> dayListEntry : lessonsByDay.entrySet()) {
            System.out.println(dayListEntry.getKey() + " " + dayListEntry.getValue());
        }
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
