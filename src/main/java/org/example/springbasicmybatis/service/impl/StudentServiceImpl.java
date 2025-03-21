package org.example.springbasicmybatis.service.impl;

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

    @Override
    public List<StudentModel> GetAllStudents() {
        return studentRepository.GetAllStudents();
    }
}
