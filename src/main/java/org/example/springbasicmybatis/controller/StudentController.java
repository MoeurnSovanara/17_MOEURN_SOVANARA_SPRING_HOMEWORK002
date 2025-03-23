package org.example.springbasicmybatis.controller;
import org.example.springbasicmybatis.model.dto.request.StudentRequest;
import org.example.springbasicmybatis.model.dto.respone.ApiResponse;
import org.example.springbasicmybatis.model.entity.StudentModel;
import org.example.springbasicmybatis.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//   i) Post (/api/v1/students) : add new student
    @PostMapping
    public ResponseEntity<ApiResponse<StudentModel>> addStudent(@RequestBody StudentRequest studentRequest) {
        ApiResponse<StudentModel> response= ApiResponse.<StudentModel>builder()
                .success(true)
                .message("Add Student Successfully")
                .status(HttpStatus.OK)
                .payload(studentService.addStudent(studentRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }





    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentModel>>> GetAllStudents(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size){
        ApiResponse<List<StudentModel>> response= ApiResponse.<List<StudentModel>>builder()
                .success(true)
                .message("Get All Students Successfully")
                .status(HttpStatus.OK)
                .payload(studentService.GetAllStudents(page,size))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }




}
