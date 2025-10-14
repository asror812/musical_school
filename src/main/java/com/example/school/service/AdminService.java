package com.example.school.service;

import org.springframework.stereotype.Service;
import com.example.school.dto.DashboardInfo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Getter
public class AdminService {

    private final SubjectService subjectService;
    private final PupilService pupilService;
    private final LessonService lessonService;
    private final TeacherService teacherService;

    public DashboardInfo getDashboardInfo() {

        DashboardInfo dashboardInfo = new DashboardInfo();

        dashboardInfo.setLessonsCount(lessonService.count());
        dashboardInfo.setPupilsCount(pupilService.count());
        dashboardInfo.setSubjectCount(subjectService.count());
        dashboardInfo.setTeachersCount(teacherService.count());

        return dashboardInfo;
    }

}
