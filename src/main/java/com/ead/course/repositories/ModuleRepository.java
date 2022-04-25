package com.ead.course.repositories;

import java.util.List;
import java.util.UUID;

import com.ead.course.models.ModuleModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModuleRepository extends JpaRepository<ModuleModel, UUID> {

    // @Modifying para alterações no bd
    @Query(value = "select * from modules where course_course_id = :courseId", nativeQuery = true)
    List<ModuleModel> findAllModulesIntoCourse(@Param("courseId") UUID courseId);
}
