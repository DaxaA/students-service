package com.spring.students.services;

import com.spring.students.dto.student.StudentCreateDTO;
import com.spring.students.dto.student.StudentDTO;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    StudentDTO saveStudent(StudentCreateDTO student);
    List<StudentDTO> getStudents();
    StudentDTO getStudentById(Long id);
    StudentDTO updateStudent(Long id, StudentCreateDTO student);
    String deleteStudentById(Long id);
    List<StudentDTO> getStudentsBySpecialty(String specialty);
    List<StudentDTO> download(List<StudentDTO> data) throws IOException;
    List<Object[]> report() throws IOException;
}
