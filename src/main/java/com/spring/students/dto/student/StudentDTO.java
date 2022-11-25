package com.spring.students.dto.student;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StudentDTO {
    private final Long id;
    private final String name;
    private final String phone;
    private final String address;
    private final Integer year;
    private final String specialty;
}
