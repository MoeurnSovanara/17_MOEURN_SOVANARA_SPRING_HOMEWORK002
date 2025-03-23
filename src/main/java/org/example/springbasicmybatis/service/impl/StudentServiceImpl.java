package org.example.springbasicmybatis.service.impl;

import org.example.springbasicmybatis.model.dto.request.StudentRequest;
import org.example.springbasicmybatis.model.entity.StudentModel;
import org.example.springbasicmybatis.repository.StudentRepository;
import org.example.springbasicmybatis.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Post Student
    @Override
    public StudentModel addStudent(StudentRequest studentRequest) {
        return studentRepository.addStudent(studentRequest);
    }


    // Get all Student
    @Override
    public List<StudentModel> GetAllStudents(Integer page, Integer size) {
        return studentRepository.GetAllStudents(page, size);
    }

}
