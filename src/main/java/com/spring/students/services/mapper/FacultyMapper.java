package com.spring.students.services.mapper;

import com.spring.students.dto.faculty.FacultyDTO;
import com.spring.students.entity.Faculty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FacultyMapper {
    public FacultyDTO toDto(Faculty faculty) {
        return new FacultyDTO(faculty.getId(), faculty.getName());
    }

    public List<FacultyDTO> toDtoList(List<Faculty> faculties) {
        return faculties.stream().map(this::toDto).collect(Collectors.toList());
    }
}
