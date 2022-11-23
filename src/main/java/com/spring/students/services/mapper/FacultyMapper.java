package com.spring.students.services.mapper;

import com.spring.students.dto.FacultyCreateDTO;
import com.spring.students.dto.FacultyDTO;
import com.spring.students.entity.Faculty;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultyMapper {
    FacultyDTO toDto(Faculty faculty);
    FacultyCreateDTO toDtoForCreate(Faculty faculty);
}
