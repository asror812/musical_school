package com.example.school.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.school.dao.LessonRepository;
import com.example.school.dao.SubjectRepository;
import com.example.school.dao.TeacherRepository;
import com.example.school.dto.request.LessonCreateDTO;
import com.example.school.dto.request.LessonUpdateDTO;
import com.example.school.dto.response.LessonResponseDTO;
import com.example.school.exception.EntityNotFoundException;
import com.example.school.model.Lesson;
import com.example.school.model.Subject;
import com.example.school.model.Teacher;
import com.example.school.model.enums.Day;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Getter
public class LessonService extends GenericService<LessonResponseDTO, Lesson, Long> {

    private final Class<Lesson> entityClass = Lesson.class;
    private final Class<LessonResponseDTO> responseType = LessonResponseDTO.class;
    private final LessonRepository repository;
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

        Lesson saved = repository.save(lesson);
        return mapper.map(saved, LessonResponseDTO.class);
    }

    public LessonResponseDTO update(Long id, LessonUpdateDTO updateDTO) {
        Lesson lesson = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Lesson with id: %s not found".formatted(id)));

        Teacher teacher = teacherRepository.findById(updateDTO.getTeacherId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Teacher with id: %s not found".formatted(updateDTO.getTeacherId())));

        lesson.setDayOfWeek(updateDTO.getDayOfWeek());
        lesson.setFrom(updateDTO.getFrom());
        lesson.setTo(updateDTO.getTo());
        lesson.setTeacher(teacher);

        Lesson saved = repository.save(lesson);
        return mapper.map(saved, LessonResponseDTO.class);
    }

    public EnumMap<Day, List<LessonResponseDTO>> getScheduleByDay() {
        EnumMap<Day, List<LessonResponseDTO>> schedule = new EnumMap<>(Day.class);
        List<LessonResponseDTO> lessons = getAll();

        for (Day day : Day.values()) {
            schedule.put(day, new ArrayList<>());
        }

        for (LessonResponseDTO lesson : lessons) {
            schedule.computeIfAbsent(lesson.getDayOfWeek(), _ -> new ArrayList<>()).add(lesson);
        }

        for (Map.Entry<Day, List<LessonResponseDTO>> entry : schedule.entrySet()) {
            entry.getValue().sort(Comparator.comparing(LessonResponseDTO::getFrom));
        }

        return schedule;
    }

    public long count() {
        return repository.count();
    }
}
