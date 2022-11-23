package com.spring.students.services;

import com.spring.students.dto.FacultyCreateDTO;
import com.spring.students.dto.FacultyDTO;
import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.entity.Faculty;
import com.spring.students.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyService {
    FacultyDTO saveFaculty(FacultyCreateDTO faculty);
    List<FacultyDTO> getAllFaculties();
    List<SpecialtyDTO> getSpecialties(FacultyDTO faculty);
    FacultyDTO getByName(String name);
    FacultyDTO updateFaculty(FacultyDTO faculty);
    String deleteById(Long id);
}
