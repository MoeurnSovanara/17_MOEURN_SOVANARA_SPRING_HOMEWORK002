package org.example.springbasicmybatis.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springbasicmybatis.model.entity.InstructorsModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String course_name;
    private String description;
    private Integer instructor_id;
}
