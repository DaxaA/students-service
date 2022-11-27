package com.spring.students.services.impl;

import com.spring.students.dto.faculty.FacultyCreateDTO;
import com.spring.students.dto.faculty.FacultyDTO;
import com.spring.students.dto.specialty.SpecialtyDTO;
import com.spring.students.entity.Faculty;
import com.spring.students.repositories.FacultyRepository;
import com.spring.students.services.FacultyService;
import com.spring.students.services.mapper.FacultyMapper;
import com.spring.students.services.mapper.SpecialtyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;
    private final SpecialtyMapper specialtyMapper;

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
        return facultyMapper.toDtoList(facultyRepository.findAll());
    }

    @Override
    public FacultyDTO getByName(String name) {
        return facultyMapper.toDto(facultyRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("Faculty not found!")));
    }

    @Override
    public List<SpecialtyDTO> getSpecialties(String name) {
        return specialtyMapper.toDtoList(facultyRepository.findByName(name).orElseThrow().getSpecialties());
    }

    @Override
    @Transactional
    public FacultyDTO updateFaculty(Long id, FacultyCreateDTO faculty) {
        Faculty existing = facultyRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Faculty not found!"));
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
