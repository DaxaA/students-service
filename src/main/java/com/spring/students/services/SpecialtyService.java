package com.spring.students.services;

import com.spring.students.dto.FacultyDTO;
import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.entity.Faculty;
import com.spring.students.entity.Specialty;
import com.spring.students.entity.Student;

import java.util.List;

public interface SpecialtyService {
    Specialty saveSpecialty(SpecialtyDTO student);
    List<Specialty> getAllSpecialties();
    List<Specialty> getSpecialtyByFaculty(FacultyDTO faculty);
    Specialty getByName(String name);
    Specialty updateSpecialty(SpecialtyDTO specialtyDTO);
    String deleteById(Long id);
}
