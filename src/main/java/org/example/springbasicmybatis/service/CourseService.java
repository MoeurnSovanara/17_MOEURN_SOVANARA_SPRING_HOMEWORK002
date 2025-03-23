package org.example.springbasicmybatis.service;

import org.example.springbasicmybatis.model.dto.request.CourseRequest;
import org.example.springbasicmybatis.model.entity.CourseModel;

import java.util.List;

public interface CourseService {
    List<CourseModel> getAllCourses();

    CourseModel addCourse(CourseRequest courseRequest);

    CourseModel getCourseById(Integer id);

    CourseModel updateCourse(Integer id, CourseRequest courseRequest);

    CourseModel deleteCourseById(Integer id);
}
