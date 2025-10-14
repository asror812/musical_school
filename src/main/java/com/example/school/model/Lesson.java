package com.example.school.model;

import java.io.Serializable;
import java.time.LocalTime;

import com.example.school.model.enums.Day;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "lessons")
@Entity
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne()
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "day_of_week")
    @Enumerated(value = EnumType.STRING)
    private Day dayOfWeek;

    @Column(name = "start_time")
    private LocalTime from;

    @Column(name = "end_time")
    private LocalTime to;

    public Lesson(Teacher teacher, Subject subject, Day dayOfWeek, LocalTime from, LocalTime to) {
        this.teacher = teacher;
        this.subject = subject;
        this.dayOfWeek = dayOfWeek;
        this.from = from;
        this.to = to;
    }
}