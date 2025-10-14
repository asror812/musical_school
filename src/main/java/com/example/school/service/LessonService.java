package com.example.school.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.school.dao.LessonRepository;
import com.example.school.dao.PupilRepository;
import com.example.school.dao.SubjectRepository;
import com.example.school.dao.TeacherRepository;
import com.example.school.dto.request.LessonCreateDTO;
import com.example.school.dto.request.LessonUpdateDTO;
import com.example.school.dto.response.LessonResponseDTO;
import com.example.school.exception.EntityNotFoundException;
import com.example.school.model.Lesson;
import com.example.school.model.Subject;
import com.example.school.model.Teacher;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Getter
public class LessonService extends GenericService<LessonResponseDTO, Lesson, Long> {

    private final Class<Lesson> entityClass = Lesson.class;
    private final Class<LessonResponseDTO> responseType = LessonResponseDTO.class;
    private final LessonRepository repository;
    private final PupilRepository pupuPupilRepository;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    private final ModelMapper mapper;

    public LessonResponseDTO create(LessonCreateDTO createDTO) {
        Subject subject = subjectRepository.findById(createDTO.getSubjectId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Subject with id: %s not found".formatted(createDTO.getSubjectId())));

        Teacher teacher = teacherRepository.findById(createDTO.getTeacherId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Teacher with id: %s not found".formatted(createDTO.getTeacherId())));

        Lesson lesson = new Lesson();
        lesson.setDayOfWeek(createDTO.getDayOfWeek());
        lesson.setFrom(createDTO.getFrom());
        lesson.setTo(createDTO.getTo());
        lesson.setSubject(subject);
        lesson.setTeacher(teacher);

        repository.save(lesson);

        return mapper.map(lesson, LessonResponseDTO.class);
    }

    public LessonResponseDTO update(Long id, LessonUpdateDTO updateDTO) {
        Lesson lesson = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Lesson with id: %s not found".formatted(id)));

        Teacher teacher = teacherRepository.findById(updateDTO.getTeacherId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Teacher with id: %s not found".formatted(id)));

        lesson.setDayOfWeek(updateDTO.getDayOfWeek());
        lesson.setFrom(updateDTO.getFrom());
        lesson.setTo(updateDTO.getTo());

        lesson.setTeacher(teacher);

        return mapper.map(updateDTO, LessonResponseDTO.class);
    }

    public long count() {
        return repository.count();
    }

}
