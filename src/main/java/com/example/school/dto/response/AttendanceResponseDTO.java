package com.example.school.dto.response;

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
public class AttendanceResponseDTO {
    private UUID id;

    private UUID lessonId;

    private UUID pupilId;

    private LocalDate date;

    private Status status;
}
