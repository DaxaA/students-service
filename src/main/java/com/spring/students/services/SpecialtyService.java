package com.spring.students.services;

import com.spring.students.dto.faculty.FacultyDTO;
import com.spring.students.dto.specialty.SpecialtyCreateDTO;
import com.spring.students.dto.specialty.SpecialtyDTO;

import java.util.List;

public interface SpecialtyService {
    SpecialtyDTO saveSpecialty(SpecialtyCreateDTO student);
    List<SpecialtyDTO> getAllSpecialties();
    List<SpecialtyDTO> getSpecialtyByFaculty(FacultyDTO faculty);
    SpecialtyDTO getByName(String name);
    SpecialtyDTO updateSpecialty(SpecialtyDTO specialtyDTO);
    String deleteById(Long id);
}
