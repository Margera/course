package com.ead.course.services.impl;

import java.util.List;

import com.ead.course.models.CourseModel;
import com.ead.course.models.LessonModel;
import com.ead.course.models.ModuleModel;
import com.ead.course.repositories.CourseRepository;
import com.ead.course.repositories.LessonRepository;
import com.ead.course.repositories.ModuleRepository;
import com.ead.course.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    LessonRepository lessonRepository;

    @Override
    public void delete(CourseModel courseModel) {
        List<ModuleModel> moduleModelList = moduleRepository.findAllModulesIntoCourse(courseModel.getCourseId());
        
        if(!moduleModelList.isEmpty()){
            for(ModuleModel module : moduleModelList){
                List<LessonModel> lessonModelsList = lessonRepository.findAllLessonsIntoCourse(module.getModuleId()); 

                if(!lessonModelsList.isEmpty()){
                    lessonRepository.deleteAll(lessonModelsList);
                }
            }   

            moduleRepository.deleteAll(moduleModelList);
        }
    }

}
