package com.example.school.dao;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.school.model.Pupil;

@Repository
public interface PupilRepository extends GenericRepository<Pupil, UUID> {

}
