package com.spring.students.dto;

import lombok.Getter;

@Getter
public class StudentDTO {
    private final Long id;
    private final String name;
    private final String phone;
    private final String address;
    private final Integer year;
    private final String specialty;

    public StudentDTO(Long id, String name, String phone, String address, Integer year, String specialty) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.year = year;
        this.specialty = specialty;
    }
}
