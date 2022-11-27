package com.spring.students.dto.faculty;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class FacultyCreateDTO {

    @NotNull
    private final String name;

    public FacultyCreateDTO(@JsonProperty("name") String name) {
        this.name = name;
    }
}
