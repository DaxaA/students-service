package com.spring.students.dto.student;

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

    public StudentCreateDTO(String name, String phone, String address, Integer year, String specialty) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.year = year;
        this.specialty = specialty;
    }
}
