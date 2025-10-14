package com.example.school.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DashboardInfo {

    private Long pupilsCount;
    private Long teachersCount;
    private Long lessonsCount;
    private Long subjectCount;
}
