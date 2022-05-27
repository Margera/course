package com.ead.course.services;

import java.util.UUID;

import com.ead.course.models.CourseModel;

public interface CourseUserService {

    boolean existsByCourseAndUserId(CourseModel courseModel, UUID userId);    
}
