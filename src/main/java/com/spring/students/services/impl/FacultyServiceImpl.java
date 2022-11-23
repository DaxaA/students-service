package com.spring.students.services.impl;

import com.spring.students.dto.FacultyCreateDTO;
import com.spring.students.dto.FacultyDTO;
import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.entity.Faculty;
import com.spring.students.entity.Specialty;
import com.spring.students.repositories.FacultyRepository;
import com.spring.students.repositories.SpecialtyRepository;
import com.spring.students.services.FacultyService;
import com.spring.students.services.mapper.FacultyMapper;
import com.spring.students.services.mapper.lists.FacultyListMapper;
import com.spring.students.services.mapper.lists.SpecialtyListMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepository facultyRepository;
    private final SpecialtyRepository specialtyRepository;
    private final FacultyMapper facultyMapper;
    private final FacultyListMapper facultyListMapper;
    private final SpecialtyListMapper specialtyListMapper;

    @Override
    @Transactional
    public FacultyDTO saveFaculty(FacultyCreateDTO faculty) {
        Faculty newFaculty = new Faculty(
                faculty.getName()
        );
        return facultyMapper.toDto(facultyRepository.save(newFaculty));
    }

    @Override
    public List<FacultyDTO> getAllFaculties() {
        return facultyListMapper.toDtoList(facultyRepository.findAll());
    }

    @Override
    public List<SpecialtyDTO> getSpecialties(FacultyDTO faculty) {
        return specialtyListMapper.toDtoList(facultyRepository.findById(faculty.getId()).orElseThrow().getSpecialties());
    }

    @Override
    public FacultyDTO getByName(String name) {
        return facultyMapper.toDto(facultyRepository.findByName(name).orElseThrow());
    }

    @Override
    @Transactional
    public FacultyDTO updateFaculty(FacultyDTO faculty) {
        Faculty existing = facultyRepository.findById(faculty.getId()).orElseThrow();
        existing.setName(faculty.getName());
        return facultyMapper.toDto(facultyRepository.saveAndFlush(existing));
    }

    @Override
    @Transactional
    public String deleteById(Long id) {
        facultyRepository.deleteById(id);
        return "Deleting was successful...";
    }
}
