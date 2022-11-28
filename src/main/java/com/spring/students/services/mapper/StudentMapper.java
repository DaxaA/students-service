package com.spring.students.services.mapper;

import com.spring.students.dto.student.StudentDTO;
import com.spring.students.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    public StudentDTO toDto(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getPhone(),
                student.getAddress(),
                student.getYear(),
                student.getSpecialty().getName());
    }
    public List<StudentDTO> toDtoList(List<Student> students) {
        return students.stream().map(this::toDto).collect(Collectors.toList());
    }
}
