package com.spring.students.dto;

import lombok.Getter;

@Getter
public class SpecialtyDTO {
    private final Long id;
    private final String name;
    private final String faculty;

    public SpecialtyDTO(Long id, String name, String faculty) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
    }
}
