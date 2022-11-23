package com.spring.students.services.impl;

import com.spring.students.dto.FacultyDTO;
import com.spring.students.entity.Faculty;
import com.spring.students.entity.Specialty;
import com.spring.students.repositories.FacultyRepository;
import com.spring.students.repositories.SpecialtyRepository;
import com.spring.students.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepository facultyRepository;
    private final SpecialtyRepository specialtyRepository;

    @Override
    public Faculty saveFaculty(FacultyDTO faculty) {
        Faculty newFaculty = new Faculty();
        newFaculty.setId(faculty.getId());
        newFaculty.setName(faculty.getName());
        return facultyRepository.save(newFaculty);
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public List<Specialty> getSpecialties(FacultyDTO faculty) {
        return specialtyRepository.findByFaculty(facultyRepository.findByName(faculty.getName()));
    }

    @Override
    public Faculty getByName(String name) {
        return facultyRepository.findByName(name);
    }

    @Override
    public Faculty updateFaculty(FacultyDTO faculty) {
        Faculty existing = new Faculty();
        existing.setId(faculty.getId());
        existing.setName(faculty.getName());
        existing.setSpecialties(facultyRepository.findByName(faculty.getName()).getSpecialties());
        return facultyRepository.saveAndFlush(existing);
    }

    @Override
    public String deleteById(Long id) {
        facultyRepository.deleteById(id);
        return "Deleting was successful...";
    }
}
