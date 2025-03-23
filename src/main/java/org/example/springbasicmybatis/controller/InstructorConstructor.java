package org.example.springbasicmybatis.controller;

import lombok.Builder;
import org.example.springbasicmybatis.model.dto.request.InstructorRequest;
import org.example.springbasicmybatis.model.dto.respone.ApiResponse;
import org.example.springbasicmybatis.model.entity.InstructorsModel;
import org.example.springbasicmybatis.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/v1/instructors")

public class InstructorConstructor {
    private final InstructorService instructorService;

    //injection bean form service by constructor
    public InstructorConstructor(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    //    i) Post (/api/v1/instructors) : add new instructor
    @PostMapping
    public ResponseEntity<ApiResponse<InstructorsModel>> addInstructor(@RequestBody InstructorRequest instructorRequest){
        ApiResponse<InstructorsModel> apiResponse = ApiResponse.<InstructorsModel>builder()
                .success(true)
                .message("Get All Instructor Successfully")
                .status(HttpStatus.OK)
                .payload(instructorService.addInstructor(instructorRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


    //   ii) Get (/api/v1/instructors/{id}) :  find instructor by id
    @GetMapping("/{instructor_id}")
    public ResponseEntity<ApiResponse<InstructorsModel>>  getAllInstructorsById(@PathVariable("instructor_id") Integer id){
        ApiResponse<InstructorsModel> apiResponse = ApiResponse.<InstructorsModel>builder()
                .success(true)
                .message("Get All Instructor Successfully")
                .status(HttpStatus.OK)
                .payload(instructorService.getAllInstructorById(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


    //    iii) Put (/api/v1/instructors/{id}) :  update information instructor by id
    @PutMapping("/{instructor_id}")
    public ResponseEntity<ApiResponse<InstructorsModel>> updateInstructor(@PathVariable("instructor_id") Integer id,@RequestBody InstructorRequest instructorRequest){

        ApiResponse<InstructorsModel> apiResponse = ApiResponse.<InstructorsModel>builder()
                .success(true)
                .message("Update Instructor Successfully")
                .status(HttpStatus.OK)
                .payload(instructorService.updateInstructor(id,instructorRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


    //    iv)    Delete (/api/v1/instructors/{id}) :  remove instructor by id
    @DeleteMapping("/{instructor_id}")
    public ResponseEntity<ApiResponse<InstructorsModel>> deleteInstructor(@PathVariable("instructor_id") Integer id){
        ApiResponse<InstructorsModel> apiResponse = ApiResponse.<InstructorsModel>builder()
                .success(true)
                .message("Delete Instructor Successfully")
                .status(HttpStatus.OK)
                .payload(instructorService.deleteInstructor(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


//    v)  Get (/api/v1/instructors) :  find all instructors
    @GetMapping
    public ResponseEntity<ApiResponse<List<InstructorsModel>>>  getAllInstructors(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size){
        ApiResponse<List<InstructorsModel>> apiResponse = ApiResponse.<List<InstructorsModel>>builder()
                .success(true)
                .message("Get All Instructor Successfully")
                .status(HttpStatus.OK)
                .payload(instructorService.getAllInstructors(page,size))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }


}
