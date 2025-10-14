package com.example.school.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.school.dao.AttendanceRepository;
import com.example.school.dao.LessonRepository;
import com.example.school.dao.PupilRepository;
import com.example.school.dto.request.AttendanceCreateDTO;
import com.example.school.dto.response.AttendanceResponseDTO;
import com.example.school.exception.EntityNotFoundException;
import com.example.school.model.Attendance;
import com.example.school.model.Lesson;
import com.example.school.model.Pupil;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Getter
public class AttendanceService
                extends GenericService<AttendanceResponseDTO, Attendance, UUID> {

        private final Class<Attendance> entityClass = Attendance.class;
        private final Class<AttendanceResponseDTO> responseType = AttendanceResponseDTO.class;
        private final AttendanceRepository repository;
        private final LessonRepository lessonRepository;
        private final PupilRepository pupilRepository;

        private final ModelMapper mapper;

        public void create(AttendanceCreateDTO createDTO) {

                Lesson lesson = lessonRepository.findById(createDTO.getLessonId())
                                .orElseThrow(() -> new EntityNotFoundException("Lesson with id: %s not found"));

                Pupil pupil = pupilRepository.findById(createDTO.getPupilId())
                                .orElseThrow(() -> new EntityNotFoundException("Pupil with id: %s not found"));

                Attendance attendance = new Attendance();
                attendance.setDate(createDTO.getDate());
                attendance.setStatus(createDTO.getStatus());
                attendance.setLesson(lesson);
                attendance.setPupil(pupil);

                repository.save(attendance);
        }

}
