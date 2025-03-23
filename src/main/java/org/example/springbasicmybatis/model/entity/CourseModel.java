package org.example.springbasicmybatis.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseModel {
    private Integer course_id;
    private String course_name;
    private String description;
    private InstructorsModel instructor;
}
