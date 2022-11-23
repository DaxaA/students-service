package com.spring.students.services.mapper.lists;

import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.entity.Specialty;
import com.spring.students.services.mapper.SpecialtyMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SpecialtyMapper.class)
public interface SpecialtyListMapper {
    List<SpecialtyDTO> toDtoList(List<Specialty> specialties);
}
