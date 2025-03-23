package org.example.springbasicmybatis.controller;


import org.example.springbasicmybatis.model.dto.request.CourseRequest;
import org.example.springbasicmybatis.model.dto.respone.ApiResponse;
import org.example.springbasicmybatis.model.entity.CourseModel;
import org.example.springbasicmybatis.model.entity.InstructorsModel;
import org.example.springbasicmybatis.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

//    injection by constructor of service
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    //    i)  Post (/api/v1/courses) : add new course
    @PostMapping
    public ResponseEntity<ApiResponse<CourseModel>> addCourse(@RequestBody CourseRequest courseRequest) {
        ApiResponse<CourseModel> apiResponse = ApiResponse.<CourseModel>builder()
                .success(true)
                .message("Add Course Successfully")
                .status(HttpStatus.OK)
                .payload(courseService.addCourse(courseRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


    //    ii) Get (/api/v1/courses/{id}) :  find course by id
    @GetMapping("/{course_id}")
    public ResponseEntity<ApiResponse<CourseModel>> getCourseById(@PathVariable("course_id") Integer id) {
        ApiResponse<CourseModel> apiResponse = ApiResponse.<CourseModel>builder()
                .success(true)
                .message("Get Course by Id Successfully")
                .status(HttpStatus.OK)
                .payload(courseService.getCourseById(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

//    iii)  Put (/api/v1/courses/{id}) :  update course by id
    @PutMapping("/{course_id}")
    public ResponseEntity<ApiResponse<CourseModel>> updateCourse(@PathVariable("course_id") Integer id, @RequestBody CourseRequest courseRequest) {
        ApiResponse<CourseModel> apiResponse = ApiResponse.<CourseModel>builder()
                .success(true)
                .message("Update course Successfully")
                .status(HttpStatus.OK)
                .payload(courseService.updateCourse(id,courseRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }



    //    iv)   Delete (/api/v1/courses/{id}) :  remove course by id
    @DeleteMapping("/{course_id}")
    public ResponseEntity<ApiResponse<CourseModel>> deleteCourseById(@PathVariable("course_id") Integer id) {
        ApiResponse<CourseModel> apiResponse = ApiResponse.<CourseModel>builder()
                .success(true)
                .message("Delete Course Successfully")
                .status(HttpStatus.OK)
                .payload(courseService.deleteCourseById(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


//    v)   Get (/api/v1/courses) :  find all courses
    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseModel>>> getAllCourses() {
        ApiResponse<List<CourseModel>> apiResponse = ApiResponse.<List<CourseModel>>builder()
                .success(true)
                .message("Get All Courses Successfully")
                .status(HttpStatus.OK)
                .payload(courseService.getAllCourses())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


}
