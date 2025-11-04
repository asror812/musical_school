package com.example.school.dao;

import org.springframework.stereotype.Repository;
import com.example.school.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.school.model.enums.Role;



@Repository
public interface UserRepository extends GenericRepository<User, UUID> {

    List<User> findAllByRole(Role role);

    Optional<User> findByIdAndRole(UUID id, Role role);

    Optional<User> findByUsername(String username);
}
