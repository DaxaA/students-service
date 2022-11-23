package com.spring.students.services.mapper;

import com.spring.students.dto.SpecialtyCreateDTO;
import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.entity.Specialty;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpecialtyMapper {
    SpecialtyDTO toDto(Specialty specialty);
    SpecialtyCreateDTO toDtoForCreate(Specialty specialty);
}
