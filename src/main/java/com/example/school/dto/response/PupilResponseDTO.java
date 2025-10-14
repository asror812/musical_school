package com.example.school.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PupilResponseDTO extends UserResponseDTO{
    private List<AttendanceResponseDTO> attendance;
}
