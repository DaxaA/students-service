package com.spring.students.services.mapper.lists;

import com.spring.students.dto.StudentDTO;
import com.spring.students.entity.Student;
import com.spring.students.services.mapper.StudentMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public interface StudentListMapper {
    List<StudentDTO> toDtoList(List<Student> students);
}
