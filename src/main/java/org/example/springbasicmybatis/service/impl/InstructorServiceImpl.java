package org.example.springbasicmybatis.service.impl;

import org.example.springbasicmybatis.model.dto.request.InstructorRequest;
import org.example.springbasicmybatis.model.entity.InstructorsModel;
import org.example.springbasicmybatis.repository.InstructorRepository;
import org.example.springbasicmybatis.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<InstructorsModel> getAllInstructors(Integer page,Integer size){
        return instructorRepository.getAllInstructors(page,size);
    }

    @Override
    public InstructorsModel getAllInstructorById(Integer id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public InstructorsModel addInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.addInstructor(instructorRequest);

    }

    @Override
    public InstructorsModel updateInstructor(Integer id, InstructorRequest instructorRequest) {
       return instructorRepository.updateInstructor(id,instructorRequest);
    }

    @Override
    public InstructorsModel deleteInstructor(Integer id) {
        return instructorRepository.deleteInstructor(id);
    }
}


