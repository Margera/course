package com.ead.course.validation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.client.HttpStatusCodeException;

import com.ead.course.dtos.CourseDto;
import com.ead.course.enums.*;

@Component
public class CourseValidator implements Validator {

    @Autowired
    @Qualifier("defaultValidator")
    private Validator validator;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourseDto courseDto = (CourseDto) target;
        validator.validate(courseDto, errors);

        if(!errors.hasErrors()){
            validateUserInstructor(courseDto.getUserInstructor(), errors);
        }
    }

    private void validateUserInstructor(UUID userInstructor, Errors errors){
        // ResponseEntity<UserDto> responseUserinstructor;
        // try {
        //     responseUserinstructor = authUserClient.getOneUserById(userInstructor);      
            
        //     if(responseUserinstructor.getBody().getUserType().equals(UserType.STUDENT)){
        //         errors.rejectValue("userInstructor", "UserInstructorError","User must be INSTRUCTOR or ADMIN");   
        //     }
        // } catch (HttpStatusCodeException e) {
        //     if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)){
        //         errors.rejectValue("userInstructor", "UserInstrictorError", "Instructor not found.");
        //     }
        // }
    }
}
