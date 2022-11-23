package com.spring.students.services.impl;

import com.spring.students.dto.StudentDTO;
import com.spring.students.entity.Student;
import com.spring.students.repositories.SpecialtyRepository;
import com.spring.students.repositories.StudentRepository;
import com.spring.students.services.SpecialtyService;
import com.spring.students.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SpecialtyRepository specialtyRepository;

    @Override
    public Student saveStudent(StudentDTO student) {
        Student newStudent = new Student();
        newStudent.setId(student.getId());
        newStudent.setName(student.getName());
        newStudent.setPhone(student.getPhone());
        newStudent.setAddress(student.getAddress());
        newStudent.setYear(student.getYear());
        newStudent.setSpecialty(specialtyRepository.findByName(student.getSpecialty()));
        return studentRepository.save(newStudent);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student updateStudent(StudentDTO student) {
        Student existing = studentRepository.findById(student.getId()).orElseThrow();
        existing.setName(student.getName());
        existing.setPhone(student.getPhone());
        existing.setAddress(student.getAddress());
        existing.setYear(student.getYear());
        existing.setSpecialty(specialtyRepository.findByName(student.getName()));
        return studentRepository.saveAndFlush(existing);
    }

    @Override
    public String deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return "Deleting was successful...";
    }
}
