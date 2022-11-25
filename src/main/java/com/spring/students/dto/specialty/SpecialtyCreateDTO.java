package com.spring.students.dto.specialty;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class SpecialtyCreateDTO {
    @NotNull
    private final String name;
    @NotNull
    private final String faculty;

    public SpecialtyCreateDTO(String name, String faculty) {
        this.name = name;
        this.faculty = faculty;
    }
}
