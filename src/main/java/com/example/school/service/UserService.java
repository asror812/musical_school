package com.example.school.service;

import java.util.UUID;

import com.example.school.dto.request.SignInDTO;
import com.example.school.model.enums.Role;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.school.dao.UserRepository;
import com.example.school.dto.response.UserResponseDTO;
import com.example.school.model.User;

import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@Getter
@RequiredArgsConstructor
public class UserService extends GenericService<UserResponseDTO, User, UUID>
        implements UserDetailsService {

    private final UserRepository repository;

    private final Class<User> entityClass = User.class;

    private final Class<UserResponseDTO> responseType = UserResponseDTO.class;

    private final ModelMapper mapper;

    private final UsernameGeneratorService usernameGeneratorService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User with username: %s not found".formatted(username)));
    }

    public Role signIn(@Valid SignInDTO signInDTO) {
        User usernameOrPasswordIncorrect = repository.findByUsernameAndPassword(signInDTO.getUsername(), signInDTO.getPassword())
                .orElseThrow(() -> new UsernameNotFoundException("Username or password incorrect"));

        return usernameOrPasswordIncorrect.getRole();
    }
}
