package com.spring.students.services.impl;

import com.spring.students.dto.FacultyDTO;
import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.entity.Faculty;
import com.spring.students.entity.Specialty;
import com.spring.students.entity.Student;
import com.spring.students.repositories.FacultyRepository;
import com.spring.students.repositories.SpecialtyRepository;
import com.spring.students.services.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;
    private final FacultyRepository facultyRepository;

    @Override
    public Specialty saveSpecialty(SpecialtyDTO specialty) {
        Specialty newSpecialty = new Specialty();
        newSpecialty.setId(specialty.getId());
        newSpecialty.setName(specialty.getName());
        newSpecialty.setFaculty(facultyRepository.findByName(specialty.getName()));
        return specialtyRepository.save(newSpecialty);
    }

    @Override
    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }

    @Override
    public List<Specialty> getSpecialtyByFaculty(FacultyDTO faculty) {
        Faculty newFaculty = facultyRepository.findByName(faculty.getName());
        return specialtyRepository.findByFaculty(newFaculty);
    }

    @Override
    public Specialty getByName(String name) {
        return specialtyRepository.findByName(name);
    }

    @Override
    public Specialty updateSpecialty(SpecialtyDTO specialty) {
        Specialty existing = new Specialty();
        existing.setId(specialty.getId());
        existing.setName(specialty.getName());
        existing.setFaculty(facultyRepository.findByName(specialty.getFaculty()));
        existing.setStudents(specialtyRepository.findByName(specialty.getName()).getStudents());
        return specialtyRepository.saveAndFlush(existing);
    }

    @Override
    public String deleteById(Long id) {
        specialtyRepository.deleteById(id);
        return "Deleting was successful...";
    }
}
