package com.example.school.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class TeacherResponseDTO extends UserResponseDTO{

    private String phoneNumber;

    private List<SubjectResponseDTO> specializations;
}
