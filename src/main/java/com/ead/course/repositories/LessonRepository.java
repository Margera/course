package com.ead.course.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ead.course.models.LessonModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LessonRepository extends JpaRepository<LessonModel, UUID>, JpaSpecificationExecutor<LessonModel>{
 
    // @Modifying para alterações no bd
    @Query(value = "select * from lessons where module_modele_id = :moduleId", nativeQuery = true)
    List<LessonModel> findAllLessonsIntoCourse(@Param("moduleId") UUID moduleId);

    @Query(value = "select * from lessons where module_module_id = :moduleId and lesson_id = :lessonId", nativeQuery = true)
    Optional<LessonModel> findLessonIntoModule(@Param("moduleId") UUID moduleId, @Param("lessonId") UUID lessonId);
}
