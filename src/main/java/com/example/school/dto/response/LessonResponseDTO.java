package com.example.school.dto.response;

import java.time.LocalTime;

import com.example.school.model.enums.Day;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LessonResponseDTO {
    private Long id;

    private TeacherResponseDTO teacher;

    private SubjectResponseDTO subject;

    private Day dayOfWeek;

    private LocalTime from;

    private LocalTime to;
}
