package com.spring.students.services;

import com.spring.students.dto.faculty.FacultyCreateDTO;
import com.spring.students.dto.faculty.FacultyDTO;

import java.util.List;

public interface FacultyService {
    FacultyDTO saveFaculty(FacultyCreateDTO faculty);
    List<FacultyDTO> getAllFaculties();
    FacultyDTO getByName(String name);
    FacultyDTO updateFaculty(Long id, FacultyCreateDTO faculty);
    String deleteById(Long id);
}
