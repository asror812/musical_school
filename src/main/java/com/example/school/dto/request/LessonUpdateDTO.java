package com.example.school.dto.request;

import java.time.LocalTime;
import java.util.UUID;

import com.example.school.model.enums.Day;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessonUpdateDTO {
    @NotNull
    private UUID teacherId;

    @NotNull
    private Day dayOfWeek;

    @NotNull
    private LocalTime from;

    @NotNull
    private LocalTime to;
}
