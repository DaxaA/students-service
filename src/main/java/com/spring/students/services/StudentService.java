package com.spring.students.services;

import com.spring.students.dto.student.StudentCreateDTO;
import com.spring.students.dto.student.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO saveStudent(StudentCreateDTO student);
    List<StudentDTO> getStudents();
    StudentDTO getStudentById(Long id);
    StudentDTO updateStudent(Long id, StudentCreateDTO student);
    String deleteStudentById(Long id);
    List<StudentDTO> getStudentsBySpecialty(String specialty);
    Integer report(Integer year);
}
