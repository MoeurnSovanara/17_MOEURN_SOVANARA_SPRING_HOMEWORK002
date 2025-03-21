package org.example.springbasicmybatis.service;

import org.example.springbasicmybatis.model.entity.StudentModel;

import java.util.List;

public interface StudentService {
    List<StudentModel> GetAllStudents();
}
