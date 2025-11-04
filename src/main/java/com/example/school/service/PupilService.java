package com.example.school.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.school.dao.PupilRepository;
import com.example.school.dto.request.PupilCreateDTO;
import com.example.school.dto.response.PupilResponseDTO;
import com.example.school.model.Pupil;
import com.example.school.model.enums.Role;
import com.example.school.utils.PasswordGeneratorUtil;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@Getter
@RequiredArgsConstructor
public class PupilService extends GenericService<PupilResponseDTO, Pupil, UUID> {

    private final Class<Pupil> entityClass = Pupil.class;
    private final Class<PupilResponseDTO> responseType = PupilResponseDTO.class;
    private final PupilRepository repository;
    private final UsernameGeneratorService usernameGeneratorService;

    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public PupilResponseDTO register(PupilCreateDTO createDTO) {
        String username = usernameGeneratorService.generateUsername(createDTO.getFirstName(), createDTO.getLastName());
        String password = PasswordGeneratorUtil.generate();

        Pupil pupil = new Pupil();

        pupil.setFirstName(createDTO.getFirstName());
        pupil.setLastName(createDTO.getLastName());
        pupil.setDateOfBirth(createDTO.getDateOfBirth());
        pupil.setPassword(passwordEncoder.encode(password));
        pupil.setUsername(username);
        pupil.setRole(Role.PUPIL);

        Pupil saved = repository.save(pupil);

        PupilResponseDTO response = mapper.map(saved, PupilResponseDTO.class);
        response.setPassword(password);
        return response;
    }


    public long count() {
        return repository.count();
    }

}
