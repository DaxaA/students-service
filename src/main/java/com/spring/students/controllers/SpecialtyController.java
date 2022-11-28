package com.spring.students.controllers;

import com.spring.students.dto.specialty.SpecialtyCreateDTO;
import com.spring.students.dto.specialty.SpecialtyDTO;
import com.spring.students.services.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/specialty")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    @GetMapping
    public List<SpecialtyDTO> getAll() throws IOException {
        List<SpecialtyDTO> data = specialtyService.getAllSpecialties();
        specialtyService.download(data);
        return data;
    }

    @PostMapping("/new")
    public SpecialtyDTO addSpecialty(@RequestBody SpecialtyCreateDTO specialtyCreateDTO){
        return specialtyService.saveSpecialty(specialtyCreateDTO);
    }

    @GetMapping("/{name}")
    public SpecialtyDTO getSpecialtyByName(@PathVariable String name) {
        return specialtyService.getByName(name);
    }

    @GetMapping("/faculty/{faculty}")
    public List<SpecialtyDTO> getSpecialtyByFaculty(@PathVariable String faculty) throws IOException {
        List<SpecialtyDTO> data = specialtyService.getSpecialtyByFaculty(faculty);
        specialtyService.download(data);
        return data;
    }

    @PutMapping("/update/{id}")
    public SpecialtyDTO updateSpecialty(@PathVariable Long id,
                                    @RequestBody SpecialtyCreateDTO specialtyCreateDTO) {
        return specialtyService.updateSpecialty(id, specialtyCreateDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSpecialty(@PathVariable Long id) {
        return specialtyService.deleteById(id);
    }

}
