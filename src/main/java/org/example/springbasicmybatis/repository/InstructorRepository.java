package org.example.springbasicmybatis.repository;

import org.apache.ibatis.annotations.*;
import org.example.springbasicmybatis.model.dto.request.InstructorRequest;
import org.example.springbasicmybatis.model.entity.InstructorsModel;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Select("""
         SELECT * FROM tbinstructors
         OFFSET #{page}
         Limit #{size}
    """)
    List<InstructorsModel> getAllInstructors(Integer page,Integer size);

    @Select("""
      SELECT * FROM tbinstructors WHERE instructor_id=#{id};
    """)

    InstructorsModel getInstructorById(Integer id);



    @Select("""
        INSERT INTO tbinstructors(instructor_name,email) VALUES
        (#{request.instructor_name},#{request.email}) RETURNING *
    """)
    @Results(id = "instructorMapper" ,value = {
            @Result(property = "instructor_id",column = "instructor_id"),
            @Result(property = "instructor_name",column = "instructor_name")
    })
    InstructorsModel addInstructor(@Param("request") InstructorRequest instructorRequest);



    @Select("""
        UPDATE tbinstructors SET instructor_name = #{request.instructor_name}, email = #{request.email}
        WHERE instructor_id = #{id} RETURNING *
    """)
    InstructorsModel updateInstructor( Integer id,@Param("request") InstructorRequest instructorRequest);


    @Select("""
       DELETE FROM tbinstructors WHERE instructor_id = #{id} RETURNING *
    """)
    InstructorsModel deleteInstructor(Integer id);
}
