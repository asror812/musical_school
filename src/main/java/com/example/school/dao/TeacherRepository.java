package com.example.school.dao;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.school.model.Teacher;

@Repository
public interface TeacherRepository extends GenericRepository<Teacher, UUID>{

    
}
