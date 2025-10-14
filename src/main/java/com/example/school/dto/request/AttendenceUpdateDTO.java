package com.example.school.dto.request;

import java.time.LocalDate;
import java.util.UUID;

import com.example.school.model.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttendenceUpdateDTO {

    private Long lessonId;

    private UUID pupilId;

    private LocalDate date;

    private Status status;
}
