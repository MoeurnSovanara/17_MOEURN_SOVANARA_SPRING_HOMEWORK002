package org.example.springbasicmybatis.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {
    private Integer student_id;
    private String student_name;
    private String email;
    private String phone_number;
    private CourseModel course;

}
