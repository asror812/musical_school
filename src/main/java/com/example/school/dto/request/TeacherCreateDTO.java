package com.example.school.dto.request;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TeacherCreateDTO extends UserCreateDTO {
    @NotNull
    private UUID subjectId;

    @NotNull
    private List<UUID> specializations;

}
