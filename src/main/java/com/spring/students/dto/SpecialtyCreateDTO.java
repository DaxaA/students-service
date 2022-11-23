package com.spring.students.dto;

import lombok.Getter;

@Getter
public class SpecialtyCreateDTO {
    private final String name;
    private final String faculty;

    public SpecialtyCreateDTO(String name, String faculty) {
        this.name = name;
        this.faculty = faculty;
    }
}
