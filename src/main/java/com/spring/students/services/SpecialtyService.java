package com.spring.students.services;

import com.spring.students.dto.specialty.SpecialtyCreateDTO;
import com.spring.students.dto.specialty.SpecialtyDTO;

import java.io.IOException;
import java.util.List;

public interface SpecialtyService {
    SpecialtyDTO saveSpecialty(SpecialtyCreateDTO student);
    List<SpecialtyDTO> getAllSpecialties();
    List<SpecialtyDTO> getSpecialtyByFaculty(String faculty);
    SpecialtyDTO getByName(String name);
    SpecialtyDTO updateSpecialty(Long id, SpecialtyCreateDTO specialtyDTO);
    String deleteById(Long id);

    List<SpecialtyDTO> download(List<SpecialtyDTO> data) throws IOException;
}
