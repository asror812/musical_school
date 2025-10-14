package com.example.school.dto.response;

import com.example.school.model.enums.SubjectType;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SubjectResponseDTO {

    private Long id;

    private String name;

    private SubjectType mode;
}
