package com.spring.students.services.impl;

import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.dto.StudentCreateDTO;
import com.spring.students.dto.StudentDTO;
import com.spring.students.entity.Student;
import com.spring.students.repositories.SpecialtyRepository;
import com.spring.students.repositories.StudentRepository;
import com.spring.students.services.StudentService;
import com.spring.students.services.mapper.SpecialtyMapper;
import com.spring.students.services.mapper.lists.StudentListMapper;
import com.spring.students.services.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SpecialtyRepository specialtyRepository;
    private final StudentMapper studentMapper;
    private final StudentListMapper studentListMapper;

    @Override
    @Transactional
    public StudentDTO saveStudent(StudentCreateDTO student) {
        Student newStudent = new Student(
                student.getName(),
                student.getPhone(),
                student.getAddress(),
                student.getYear(),
                specialtyRepository.findByName(student.getSpecialty()).orElseThrow()
        );
        return studentMapper.toDto(studentRepository.save(newStudent));
    }

    @Override
    public List<StudentDTO> getStudents() {
        return studentListMapper.toDtoList(studentRepository.findAll());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        return studentMapper.toDto(studentRepository.findById(id).orElseThrow());
    }

    @Override
    public StudentDTO getStudentByName(String name) {
        return studentMapper.toDto(studentRepository.findByName(name).orElseThrow());
    }

    @Override
    @Transactional
    public StudentDTO updateStudent(StudentDTO student) {
        Student existing = studentRepository.findById(student.getId()).orElseThrow();
        existing.setName(student.getName());
        existing.setPhone(student.getPhone());
        existing.setAddress(student.getAddress());
        existing.setYear(student.getYear());
        existing.setSpecialty(specialtyRepository.findByName(student.getName()).orElseThrow());
        return studentMapper.toDto(studentRepository.saveAndFlush(existing));
    }

    @Override
    @Transactional
    public String deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return "Deleting was successful...";
    }

    @Override
    public List<StudentDTO> getStudentsBySpecialty(SpecialtyDTO specialty){
        return studentListMapper.toDtoList(
                studentRepository.findBySpecialty(
                        specialtyRepository.findByName(specialty.getName()).orElseThrow()).orElseThrow());
    }

    @Override
    public Integer report(Integer year) {
        return null;
    }
}
