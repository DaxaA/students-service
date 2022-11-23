package com.spring.students.services.impl;

import com.spring.students.dto.FacultyDTO;
import com.spring.students.dto.SpecialtyCreateDTO;
import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.entity.Specialty;
import com.spring.students.repositories.FacultyRepository;
import com.spring.students.repositories.SpecialtyRepository;
import com.spring.students.services.SpecialtyService;
import com.spring.students.services.mapper.lists.SpecialtyListMapper;
import com.spring.students.services.mapper.SpecialtyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;
    private final FacultyRepository facultyRepository;
    private final SpecialtyMapper specialtyMapper;
    private final SpecialtyListMapper specialtyListMapper;

    @Override
    @Transactional
    public SpecialtyDTO saveSpecialty(SpecialtyCreateDTO specialty) {
        Specialty newSpecialty = new Specialty(
                specialty.getName(),
                facultyRepository.findByName(specialty.getFaculty()).orElseThrow()
        );
        return specialtyMapper.toDto(specialtyRepository.save(newSpecialty));
    }

    @Override
    public List<SpecialtyDTO> getAllSpecialties() {
        return specialtyListMapper.toDtoList(specialtyRepository.findAll());
    }

    @Override
    public List<SpecialtyDTO> getSpecialtyByFaculty(FacultyDTO faculty) {
        return specialtyListMapper.toDtoList(
                specialtyRepository.findByFaculty(
                        facultyRepository.findByName(faculty.getName()).orElseThrow()));
    }

    @Override
    public SpecialtyDTO getByName(String name) {
        return specialtyMapper.toDto(specialtyRepository.findByName(name).orElseThrow());
    }

    @Override
    @Transactional
    public SpecialtyDTO updateSpecialty(SpecialtyDTO specialty) {
        Specialty existing = specialtyRepository.findById(specialty.getId()).orElseThrow();
        existing.setName(specialty.getName());
        existing.setFaculty(facultyRepository.findByName(specialty.getFaculty()).orElseThrow());
        return specialtyMapper.toDto(specialtyRepository.saveAndFlush(existing));
    }

    @Override
    @Transactional
    public String deleteById(Long id) {
        specialtyRepository.deleteById(id);
        return "Deleting was successful...";
    }
}
