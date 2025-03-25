package org.example.springbasicmybatis.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbasicmybatis.model.entity.CourseModel;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String student_name;
    private String email;
    private String phone_number;
    private List<CourseModel> course;

}
