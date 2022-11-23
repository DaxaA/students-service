package com.spring.students.services;

import com.spring.students.dto.FacultyDTO;
import com.spring.students.dto.SpecialtyCreateDTO;
import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.entity.Faculty;
import com.spring.students.entity.Specialty;
import com.spring.students.entity.Student;

import java.util.List;

public interface SpecialtyService {
    SpecialtyDTO saveSpecialty(SpecialtyCreateDTO student);
    List<SpecialtyDTO> getAllSpecialties();
    List<SpecialtyDTO> getSpecialtyByFaculty(FacultyDTO faculty);
    SpecialtyDTO getByName(String name);
    SpecialtyDTO updateSpecialty(SpecialtyDTO specialtyDTO);
    String deleteById(Long id);
}
