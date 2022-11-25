package com.spring.students.services.impl;

import com.spring.students.dto.student.StudentCreateDTO;
import com.spring.students.dto.student.StudentDTO;
import com.spring.students.entity.Student;
import com.spring.students.repositories.SpecialtyRepository;
import com.spring.students.repositories.StudentRepository;
import com.spring.students.services.StudentService;
import com.spring.students.services.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SpecialtyRepository specialtyRepository;
    private final StudentMapper studentMapper;

    @Override
    @Transactional
    public StudentDTO saveStudent(StudentCreateDTO student) {
        Student newStudent = new Student(
                student.getName(),
                student.getPhone(),
                student.getAddress(),
                student.getYear(),
                specialtyRepository.findByName(student.getSpecialty()).orElseThrow(() -> new NoSuchElementException("Specialty not found!"))
        );
        return studentMapper.toDto(studentRepository.save(newStudent));
    }

    @Override
    public List<StudentDTO> getStudents() {
        return studentMapper.toDtoList(studentRepository.findAll());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        return studentMapper.toDto(studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Student with id " + id + " not found!")));
    }

    @Override
    @Transactional
    public StudentDTO updateStudent(Long id, StudentCreateDTO student) {
        Student existing = studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Student not found!"));
        existing.setName(student.getName());
        existing.setPhone(student.getPhone());
        existing.setAddress(student.getAddress());
        existing.setYear(student.getYear());
        existing.setSpecialty(specialtyRepository.findByName(student.getName()).orElseThrow(() -> new NoSuchElementException("Specialty not found!")));
        return studentMapper.toDto(studentRepository.saveAndFlush(existing));
    }

    @Override
    @Transactional
    public String deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return "Deleting was successful...";
    }

    @Override
    public List<StudentDTO> getStudentsBySpecialty(String specialty){
        return studentMapper.toDtoList(
                studentRepository.findBySpecialty(
                        specialtyRepository.findByName(specialty)
                                .orElseThrow(() -> new NoSuchElementException("Specialty not found!")))
                        .orElseThrow(() -> new NoSuchElementException("Students not found!")));
    }

    @Override
    public Integer report(Integer year) {
        return null;
    }
}
