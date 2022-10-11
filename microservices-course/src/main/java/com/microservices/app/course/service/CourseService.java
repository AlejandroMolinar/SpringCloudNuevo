package com.microservices.app.course.service;

import com.microservices.app.commons.service.CommonService;
import com.microservices.app.course.models.entity.Course;

public interface CourseService extends CommonService<Course>{
    public Course findCourseByStudentId(Long studentId);
        
}