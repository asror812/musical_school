package com.example.school.service;

import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.school.dao.TeacherRepository;
import com.example.school.dto.request.TeacherCreateDTO;
import com.example.school.dto.response.TeacherResponseDTO;
import com.example.school.model.Teacher;
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

    public TeacherResponseDTO register(TeacherCreateDTO createDTO) {
        String username = usernameGeneratorService.generateUsername(createDTO.getFirstName(), createDTO.getLastName());
        String password = PasswordGeneratorUtil.generate();

        Teacher teacher = new Teacher();
        teacher.setFirstName(createDTO.getFirstName());
        teacher.setLastName(createDTO.getLastName());
        teacher.setDateOfBirth(createDTO.getDateOfBirth());

        teacher.setUsername(username);
        teacher.setPassword(password);
        teacher.setSpecializations(null);

        return mapper.map(teacher, TeacherResponseDTO.class);
    }

    public long count() {
        return repository.count();
    }

 /*   public void deleteLessons(UUID id) {
        Teacher teacher = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Teacher with id not found"));

        teacher.getLes
    }*/
}
