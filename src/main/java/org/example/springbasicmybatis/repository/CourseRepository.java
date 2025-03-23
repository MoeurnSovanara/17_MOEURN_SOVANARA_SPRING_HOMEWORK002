package org.example.springbasicmybatis.repository;

import org.apache.ibatis.annotations.*;
import org.example.springbasicmybatis.model.dto.request.CourseRequest;
import org.example.springbasicmybatis.model.entity.CourseModel;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("""
        INSERT INTO tbcourses (course_id, course_name, description, instructor_id)
        VALUES (#{request.course_id}, #{request.course_name}, #{request.description}, #{request.instructor_id})
    """)
    CourseModel addCourse(@Param("request") CourseRequest courseRequest);


    @Select("""
        SELECT * FROM tbcourses WHERE course_id = #{id}
    """)
    CourseModel getCourseById(Integer id);
    //Get courses in repo
    @Select("""
        SELECT * FROM tbcourses;
    """)
    @Results(id = "courseMapper" , value = {
            @Result(property = "instructor",column = "instructor_id", one = @One(
                    select = "org.example.springbasicmybatis.repository.InstructorRepository.getInstructorById"
            ))
    })

    List<CourseModel> getAllCourses();


    //Update course by id
    @Select("""
        UPDATE tbcourses SET course_name = #{request.course_name}, description= #{request.description}, instructor_id = #{request.instructor_id} 
        WHERE course_id = #{id} RETURNING *;
    """)
    CourseModel updateCourse(Integer id,@Param("request") CourseRequest courseRequest);

    // Delete course by id

    @Select("""
        DELETE FROM tbcourses WHERE course_id = #{id} RETURNING *;
    """)
    CourseModel deleteCourseById(Integer id);



}
