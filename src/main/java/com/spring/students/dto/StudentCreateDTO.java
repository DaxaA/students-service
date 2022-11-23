package com.spring.students.dto;

import lombok.Getter;

@Getter
public class StudentCreateDTO {
    private final String name;
    private final String phone;
    private final String address;
    private final Integer year;
    private final String specialty;

    public StudentCreateDTO(String name, String phone, String address, Integer year, String specialty) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.year = year;
        this.specialty = specialty;
    }
}
