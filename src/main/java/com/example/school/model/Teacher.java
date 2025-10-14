package com.example.school.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "teachers")
public class Teacher extends User {

    @Pattern(regexp = "\\d{2} \\d{3}-\\d{2}-\\d{2}", message = "Phone number must be in formate xxx-xx-xx")
    private String phoneNumber;


    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    @ManyToMany
    @JoinTable(name = "teacher_specialization", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> specializations;

}
