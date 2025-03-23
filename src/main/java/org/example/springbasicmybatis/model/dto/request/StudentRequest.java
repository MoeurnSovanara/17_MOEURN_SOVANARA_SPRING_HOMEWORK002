package org.example.springbasicmybatis.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbasicmybatis.model.entity.CourseModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String student_name;
    private String email;
    private String phone_number;
    private CourseModel course;

}
