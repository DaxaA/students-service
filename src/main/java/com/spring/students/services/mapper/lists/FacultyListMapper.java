package com.spring.students.services.mapper.lists;

import com.spring.students.dto.FacultyDTO;
import com.spring.students.entity.Faculty;
import com.spring.students.services.mapper.FacultyMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = FacultyMapper.class)
public interface FacultyListMapper {
    List<FacultyDTO> toDtoList(List<Faculty> faculties);
}
