package com.example.school.dto.response;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDTO {

    private UUID id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private LocalDate dateOfBirth;
}
