package com.ead.course.repositories;
import java.util.UUID;

import com.ead.course.models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, UUID>{

}
