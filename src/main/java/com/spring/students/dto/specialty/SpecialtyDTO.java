package com.spring.students.dto.specialty;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SpecialtyDTO {
    private final Long id;
    private final String name;
    private final String faculty;
}
