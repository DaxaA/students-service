package com.spring.students.services.mapper;

import com.spring.students.dto.StudentCreateDTO;
import com.spring.students.dto.StudentDTO;
import com.spring.students.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toDto(Student student);
    StudentCreateDTO toDtoForCreate(Student student);
}
