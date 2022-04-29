package com.ead.course.services.impl;

import java.util.List;

import com.ead.course.models.LessonModel;
import com.ead.course.models.ModuleModel;
import com.ead.course.repositories.LessonRepository;
import com.ead.course.repositories.ModuleRepository;
import com.ead.course.services.ModuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModuleServiceImpl implements ModuleService{
    
    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    LessonRepository lessonRepository;

    @Transactional
    @Override
    public void delete(ModuleModel moduleModel) {
        List<LessonModel> lessonModelsList = lessonRepository.findAllLessonsIntoCourse(moduleModel.getModuleId()); 

        if(!lessonModelsList.isEmpty()){
            lessonRepository.deleteAll(lessonModelsList);
        }

        moduleRepository.delete(moduleModel);        
    }
}
