package org.example.springbasicmybatis.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InstructorRequest {
    private String instructor_name;
    private String email;
}
