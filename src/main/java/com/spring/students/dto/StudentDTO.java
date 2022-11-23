package com.spring.students.dto;

import com.spring.students.entity.Specialty;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
public class StudentDTO {
    private Long id;
    private String name;
    private String phone;
    private String address;
    private Integer year;
    private String specialty;

    public StudentDTO(Long id, String name, String phone, String address, Integer year, String specialty) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.year = year;
        this.specialty = specialty;
    }
}
