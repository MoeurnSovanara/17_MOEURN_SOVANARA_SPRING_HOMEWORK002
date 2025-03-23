package org.example.springbasicmybatis.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorsModel {
    private Integer instructor_id;
    private String instructor_name;
    private String email;
}
