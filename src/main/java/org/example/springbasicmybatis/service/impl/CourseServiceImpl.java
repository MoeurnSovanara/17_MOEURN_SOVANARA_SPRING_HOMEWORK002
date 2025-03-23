package org.example.springbasicmybatis.service.impl;

import org.example.springbasicmybatis.model.dto.request.CourseRequest;
import org.example.springbasicmybatis.model.entity.CourseModel;
import org.example.springbasicmybatis.repository.CourseRepository;
import org.example.springbasicmybatis.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


   // post method implement service
   @Override
   public CourseModel addCourse(CourseRequest courseRequest) {
       return courseRepository.addCourse(courseRequest);
   }

   // get course by id
    @Override
    public CourseModel getCourseById(Integer id) {
        return courseRepository.getCourseById(id);
    }

    //update course by id
    @Override
    public CourseModel updateCourse(Integer id, CourseRequest courseRequest) {
        return courseRepository.updateCourse(id,courseRequest);
    }


    //Delete course by id
    @Override
    public CourseModel deleteCourseById(Integer id) {
        return courseRepository.deleteCourseById(id);
    }


    @Override
    public List<CourseModel> getAllCourses() {
        return courseRepository.getAllCourses();
    }


}
