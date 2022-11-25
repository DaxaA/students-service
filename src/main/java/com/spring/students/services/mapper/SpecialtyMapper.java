package com.spring.students.services.mapper;

import com.spring.students.dto.specialty.SpecialtyDTO;
import com.spring.students.entity.Specialty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpecialtyMapper {
    public SpecialtyDTO toDto(Specialty specialty) {
        return new SpecialtyDTO(specialty.getId(), specialty.getName(), specialty.getFaculty().getName());
    }
    public List<SpecialtyDTO> toDtoList(List<Specialty> specialties) {
        return specialties.stream().map(this::toDto).collect(Collectors.toList());
    }
}
