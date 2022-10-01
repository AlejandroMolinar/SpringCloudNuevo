package com.microservices.app.course.service;

import org.springframework.stereotype.Service;

import com.microservices.app.commons.service.CommonServiceImp;
import com.microservices.app.course.models.entity.Course;
import com.microservices.app.course.models.repository.CourseRepository;

@Service 
public class CourseServiceImp extends CommonServiceImp<Course, CourseRepository>implements CourseService {


}
