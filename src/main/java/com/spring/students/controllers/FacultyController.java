package com.spring.students.controllers;

import com.spring.students.dto.faculty.FacultyCreateDTO;
import com.spring.students.dto.faculty.FacultyDTO;
import com.spring.students.dto.specialty.SpecialtyDTO;
import com.spring.students.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faculties")
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping
    public List<FacultyDTO> getAll() {
        return facultyService.getAllFaculties();
    }

    @PostMapping("/new")
    public FacultyDTO addFaculty(@RequestBody FacultyCreateDTO facultyCreateDTO){
        return facultyService.saveFaculty(facultyCreateDTO);
    }

    @GetMapping("/{name}")
    public FacultyDTO getFacultyByName(@PathVariable String name) {
        return facultyService.getByName(name);
    }

    @GetMapping("/{name}/specialties")
    public List<SpecialtyDTO> getSpecialties(@PathVariable String name) {
        return facultyService.getSpecialties(name);
    }

    @PutMapping("/update/{id}")
    public FacultyDTO updateFaculty(@PathVariable Long id,
                                    @RequestBody FacultyCreateDTO facultyCreateDTO) {
        return facultyService.updateFaculty(id, facultyCreateDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFaculty(@PathVariable Long id) {
        return facultyService.deleteById(id);
    }

}
