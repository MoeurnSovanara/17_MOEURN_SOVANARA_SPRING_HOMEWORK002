package org.example.springbasicmybatis.repository;


import org.apache.ibatis.annotations.*;
import org.example.springbasicmybatis.model.dto.request.StudentRequest;
import org.example.springbasicmybatis.model.entity.StudentModel;

import java.util.List;

@Mapper
public interface StudentRepository {

    // post a student
    @Select("""
       INSERT INTO tbstudents(student_name, email, phone_number) 
       VALUES (#{request.student_name}, #{request.email}, #{request.phone_number}) RETURNING *;
    """)

    StudentModel addStudent(@Param("request") StudentRequest studentRequest);

// Get all student

//    @Select("""
//       SELECT * FROM tbstudents st INNER JOIN public.tbstudent_course tc on st.student_id = tc.student_id WHERE st.student_id=#{id}
//   """)
//    List<StudentModel> getStudentsByCourseId(Integer id);

    @Select("""
        SELECT * FROM tbstudents;
    """)
    @Results(id = "studentMapper", value ={
        @Result(property = "course" , column = "course_id",many = @Many(
                select = "org.example.springbasicmybatis.repository.InstructorRepository.getStudentsByCourseId"
        ))
    })
    List<StudentModel> GetAllStudents(Integer page, Integer size);
}
