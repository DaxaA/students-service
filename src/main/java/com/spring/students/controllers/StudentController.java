package com.spring.students.controllers;

import com.spring.students.dto.student.StudentCreateDTO;
import com.spring.students.dto.student.StudentDTO;
import com.spring.students.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentDTO> getAll() {
        return studentService.getStudents();
    }

    @PostMapping("/new")
    public StudentDTO addStudent(@RequestBody StudentCreateDTO studentCreateDTO) {
        return studentService.saveStudent(studentCreateDTO);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public StudentDTO updateStudent(@PathVariable Long id,
                                    @RequestBody StudentCreateDTO studentCreateDTO) {
        return studentService.updateStudent(id, studentCreateDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/specialty/{specialty}")
    public List<StudentDTO> getStudentsBySpecialty(@PathVariable String specialty) {
        return studentService.getStudentsBySpecialty(specialty);
    }

    @GetMapping("/report")
    public List<Object[]> getFullReport() throws IOException {
        return studentService.report();
    }
}
