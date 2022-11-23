package com.spring.students.services;

import com.spring.students.dto.FacultyDTO;
import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.dto.StudentCreateDTO;
import com.spring.students.dto.StudentDTO;
import com.spring.students.entity.Faculty;
import com.spring.students.entity.Specialty;
import com.spring.students.entity.Student;

import java.util.List;

public interface StudentService {
    StudentDTO saveStudent(StudentCreateDTO student);
    List<StudentDTO> getStudents();
    StudentDTO getStudentById(Long id);
    StudentDTO getStudentByName(String name);
    StudentDTO updateStudent(StudentDTO student);
    String deleteStudentById(Long id);
    List<StudentDTO> getStudentsBySpecialty(SpecialtyDTO specialty);
    Integer report(Integer year);
}
