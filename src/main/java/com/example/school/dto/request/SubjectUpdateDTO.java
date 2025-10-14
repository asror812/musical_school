package com.example.school.dto.request;

import com.example.school.model.enums.SubjectType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectUpdateDTO {
    @NotBlank
    private String name;

    @NotNull
    private SubjectType mode;
}
