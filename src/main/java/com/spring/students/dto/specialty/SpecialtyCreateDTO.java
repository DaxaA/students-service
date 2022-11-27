package com.spring.students.dto.specialty;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class SpecialtyCreateDTO {
    @NotNull
    private final String name;
    @NotNull
    private final String faculty;

    public SpecialtyCreateDTO(@JsonProperty("name") String name,
                              @JsonProperty("faculty") String faculty) {
        this.name = name;
        this.faculty = faculty;
    }
}
