package com.spring.students.dto;

import lombok.Getter;

@Getter
public class FacultyDTO {
    private final Long id;
    private final String name;

    public FacultyDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
