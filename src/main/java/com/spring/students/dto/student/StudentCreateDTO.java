package com.spring.students.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class StudentCreateDTO {
    @NotNull
    private final String name;
    @NotNull
    private final String phone;
    @NotNull
    private final String address;
    @NotNull
    private final Integer year;
    @NotNull
    private final String specialty;

    public StudentCreateDTO(@JsonProperty("name") String name,
                            @JsonProperty("phone") String phone,
                            @JsonProperty("address") String address,
                            @JsonProperty("year") Integer year,
                            @JsonProperty("specialty") String specialty) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.year = year;
        this.specialty = specialty;
    }
}
