package org.example.springbasicmybatis.controller;

import org.example.springbasicmybatis.model.dto.request.StudentRequest;
import org.example.springbasicmybatis.model.dto.respone.ApiResponse;
import org.example.springbasicmybatis.model.entity.StudentModel;
import org.example.springbasicmybatis.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
//    i) Post (/api/v1/instructors) : add new instructor

//    @PostMapping
//    public List<StudentModel> addStudent(StudentRequest studentRequest){
//        return null;
//    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentModel>>> GetAllStudents(){
        ApiResponse<List<StudentModel>> response= ApiResponse.<List<StudentModel>>builder()
                .success(true)
                .message("Get All Students Successfully")
                .status(HttpStatus.OK)
                .payload(studentService.GetAllStudents())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }


}
