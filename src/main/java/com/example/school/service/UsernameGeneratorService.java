package com.example.school.service;

import org.springframework.stereotype.Service;
import com.example.school.dao.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsernameGeneratorService {

    private final UserRepository repository;

    public String generateUsername(String firstName, String lastName) {
        String baseUsername = firstName + "." + lastName;

        String username = baseUsername;

        int serialNumber = 1;

        while (repository.findByUsername(username).isPresent()) {
            username = baseUsername + serialNumber;
            serialNumber++;
        }

        return username;
    }

}
