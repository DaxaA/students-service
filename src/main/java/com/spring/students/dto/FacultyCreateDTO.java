package com.spring.students.dto;

import lombok.Getter;

@Getter
public class FacultyCreateDTO {
    private final String name;

    public FacultyCreateDTO(String name) {
        this.name = name;
    }
}
