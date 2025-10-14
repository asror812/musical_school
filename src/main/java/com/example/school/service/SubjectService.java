package com.example.school.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.school.dao.SubjectRepository;
import com.example.school.dto.request.SubjectCreateDTO;
import com.example.school.dto.request.SubjectUpdateDTO;
import com.example.school.dto.response.SubjectResponseDTO;
import com.example.school.exception.EntityNotFoundException;
import com.example.school.model.Subject;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@Getter
@RequiredArgsConstructor
public class SubjectService
        extends GenericService<SubjectResponseDTO, Subject, Long> {

    private final Class<Subject> entityClass = Subject.class;
    private final Class<SubjectResponseDTO> responseType = SubjectResponseDTO.class;
    private final SubjectRepository repository;

    private final ModelMapper mapper;

    public void create(SubjectCreateDTO createDTO) {
        Subject subject = new Subject(createDTO.getName(), createDTO.getMode());
        repository.save(subject);
    }

    public SubjectResponseDTO update(Long id, SubjectUpdateDTO updateDTO) {
        Subject subject = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id %s not found".formatted(id)));

        subject.setName(updateDTO.getName());
        subject.setMode(updateDTO.getMode());

        repository.save(subject);

        return mapper.map(subject, SubjectResponseDTO.class);
    }

    public Long count() {
        return repository.count();
    }

}
