package com.example.school.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pupils")
public class Pupil extends User {

    @OneToMany(mappedBy = "pupil")
    private List<Attendance> attendances = new ArrayList<>();

    @OneToMany(mappedBy = "pupil")
    private List<Grade> grades = new ArrayList<>();

}
