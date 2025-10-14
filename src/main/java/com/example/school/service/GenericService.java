package com.example.school.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school.dao.GenericRepository;
import com.example.school.exception.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public abstract class GenericService<RESPONSE_DTO, ENTITY, ID> {

    protected abstract Class<ENTITY> getEntityClass();

    protected abstract GenericRepository<ENTITY, ID> getRepository();

    protected abstract Class<RESPONSE_DTO> getResponseType();

    @Autowired
    private ModelMapper mapper;

    public RESPONSE_DTO getById(ID id) {
        ENTITY entity = getRepository().findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                "%s with id %s not found".formatted(getEntityClass().getSimpleName(), id)));

        return mapper.map(entity, getResponseType());
    }

    public List<RESPONSE_DTO> getAll() {
        List<ENTITY> entities = getRepository().findAll();

        return entities.stream().map(entity -> mapper.map(entity, getResponseType())).toList();
    }

    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }
}
