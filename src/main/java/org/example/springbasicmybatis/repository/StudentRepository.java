package org.example.springbasicmybatis.repository;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.springbasicmybatis.model.entity.StudentModel;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("""
        SELECT * FROM tbstudents;
    """)

    List<StudentModel> GetAllStudents();
}
