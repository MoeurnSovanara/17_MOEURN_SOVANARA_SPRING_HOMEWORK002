package org.example.springbasicmybatis.service;

import org.example.springbasicmybatis.model.dto.request.StudentRequest;
import org.example.springbasicmybatis.model.entity.StudentModel;

import java.util.List;

public interface StudentService {
    List<StudentModel> GetAllStudents(Integer page, Integer size);

    StudentModel addStudent(StudentRequest studentRequest);
}
