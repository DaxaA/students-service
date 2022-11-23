package com.spring.students.services;

import com.spring.students.dto.FacultyDTO;
import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.entity.Faculty;
import com.spring.students.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyService {
    Faculty saveFaculty(FacultyDTO faculty);
    List<Faculty> getAllFaculties();
    List<Specialty> getSpecialties(FacultyDTO faculty);
    Faculty getByName(String name);
    Faculty updateFaculty(FacultyDTO faculty);
    String deleteById(Long id);
}
