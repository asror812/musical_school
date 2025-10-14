package com.example.school.dao;

import org.springframework.stereotype.Repository;
import com.example.school.model.Lesson;

@Repository
public interface LessonRepository extends GenericRepository<Lesson, Long>{
    
}
