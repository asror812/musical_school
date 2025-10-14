package com.example.school.dao;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.school.model.Attendance;

@Repository
public interface AttendanceRepository extends GenericRepository<Attendance, UUID> {

}
