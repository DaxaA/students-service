package com.spring.students.services.impl;

import com.spring.students.dto.specialty.SpecialtyCreateDTO;
import com.spring.students.dto.specialty.SpecialtyDTO;
import com.spring.students.entity.Specialty;
import com.spring.students.repositories.FacultyRepository;
import com.spring.students.repositories.SpecialtyRepository;
import com.spring.students.services.SpecialtyService;
import com.spring.students.services.mapper.SpecialtyMapper;
import lombok.RequiredArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;
    private final FacultyRepository facultyRepository;
    private final SpecialtyMapper specialtyMapper;

    @Override
    @Transactional
    public SpecialtyDTO saveSpecialty(SpecialtyCreateDTO specialty) {
        Specialty newSpecialty = new Specialty(
                specialty.getName(),
                facultyRepository.findByName(specialty.getFaculty()).orElseThrow(() -> new NoSuchElementException("Faculty not found!"))
        );
        return specialtyMapper.toDto(specialtyRepository.save(newSpecialty));
    }

    @Override
    public List<SpecialtyDTO> getAllSpecialties() {
        return specialtyMapper.toDtoList(specialtyRepository.findAll());
    }

    @Override
    public List<SpecialtyDTO> getSpecialtyByFaculty(String faculty) {
        return specialtyMapper.toDtoList(
                specialtyRepository.findByFaculty(
                        facultyRepository.findByName(faculty).orElseThrow(() -> new NoSuchElementException("Faculty not found!"))));
    }

    @Override
    public SpecialtyDTO getByName(String name) {
        return specialtyMapper.toDto(specialtyRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("Specialty not found!")));
    }

    @Override
    @Transactional
    public SpecialtyDTO updateSpecialty(Long id, SpecialtyCreateDTO specialty) {
        Specialty existing = specialtyRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Specialty not found!"));
        existing.setName(specialty.getName());
        existing.setFaculty(facultyRepository.findByName(specialty.getFaculty()).orElseThrow(() -> new NoSuchElementException("Faculty not found!")));
        return specialtyMapper.toDto(specialtyRepository.saveAndFlush(existing));
    }

    @Override
    @Transactional
    public String deleteById(Long id) {
        specialtyRepository.deleteById(id);
        return "Deleting was successful...";
    }

    @Override
    public List<SpecialtyDTO> download(List<SpecialtyDTO> data) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("info");
        HSSFRow rowhead = sheet.createRow(0);
        int col = 0;
        rowhead.createCell(col++).setCellValue("Номер");
        rowhead.createCell(col++).setCellValue("Название");
        rowhead.createCell(col++).setCellValue("Факультет");
        for (SpecialtyDTO specialty: data) {
            HSSFRow row = sheet.createRow(data.indexOf(specialty)+1);
            col = 0;
            row.createCell(col++).setCellValue(specialty.getId());
            row.createCell(col++).setCellValue(specialty.getName());
            row.createCell(col++).setCellValue(specialty.getFaculty());
        }
        FileOutputStream fileOut = new FileOutputStream("specialties.xls");
        workbook.write(fileOut);
        fileOut.close();
        return data;
    }
}
