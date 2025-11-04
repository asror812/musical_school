package com.example.school.service;

import java.util.ArrayList;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.school.dao.TeacherRepository;
import com.example.school.dto.request.TeacherCreateDTO;
import com.example.school.dto.response.TeacherResponseDTO;
import com.example.school.model.Teacher;
import com.example.school.model.enums.Role;
import com.example.school.utils.PasswordGeneratorUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Getter
public class TeacherService extends GenericService<TeacherResponseDTO, Teacher, UUID> {

    private final Class<Teacher> entityClass = Teacher.class;
    private final TeacherRepository repository;

    private final Class<TeacherResponseDTO> responseType = TeacherResponseDTO.class;

    private final UsernameGeneratorService usernameGeneratorService;

    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public TeacherResponseDTO register(TeacherCreateDTO createDTO) {
        String username = usernameGeneratorService.generateUsername(createDTO.getFirstName(), createDTO.getLastName());
        String password = PasswordGeneratorUtil.generate();

        Teacher teacher = new Teacher();
        teacher.setFirstName(createDTO.getFirstName());
        teacher.setLastName(createDTO.getLastName());
        teacher.setDateOfBirth(createDTO.getDateOfBirth());
        teacher.setUsername(username);
        teacher.setPassword(passwordEncoder.encode(password));
        teacher.setRole(Role.TEACHER);
        teacher.setSpecializations(new ArrayList<>());

        Teacher saved = repository.save(teacher);

        TeacherResponseDTO response = mapper.map(saved, TeacherResponseDTO.class);
        response.setPassword(password);
        return response;
    }

    public long count() {
        return repository.count();
    }
}
