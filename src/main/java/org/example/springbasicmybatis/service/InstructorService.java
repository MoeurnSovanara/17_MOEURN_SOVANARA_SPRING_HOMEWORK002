package org.example.springbasicmybatis.service;

import org.example.springbasicmybatis.model.dto.request.InstructorRequest;
import org.example.springbasicmybatis.model.entity.InstructorsModel;

import java.util.List;


public interface InstructorService {
//    InstructorsModel addInstructor(InstructorRequest instructorRequest);
   List<InstructorsModel> getAllInstructors(Integer page,Integer size);
   InstructorsModel getAllInstructorById(Integer id);

   InstructorsModel addInstructor(InstructorRequest instructorRequest);

   InstructorsModel updateInstructor(Integer id, InstructorRequest instructorRequest);

   InstructorsModel deleteInstructor(Integer id);
}
