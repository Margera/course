package com.ead.course.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.ead.course.models.UserModel;

public interface UserService {

    Page<UserModel> findAll(Specification<UserModel> spec, Pageable pageable);

    UserModel save(UserModel userModel);

    void delete(UUID userId);

    Optional<UserModel> findById(UUID userInstructor);
}
