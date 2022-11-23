package com.spring.students.services;

import com.spring.students.dto.FacultyDTO;
import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.dto.StudentDTO;
import com.spring.students.entity.Faculty;
import com.spring.students.entity.Specialty;
import com.spring.students.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(StudentDTO student);
    List<Student> getStudents();
    Student getStudentById(Long id);
    Student getStudentByName(String name);
    Student updateStudent(StudentDTO student);
    String deleteStudentById(Long id);
}
