package com.spring.students.services.impl;

import com.spring.students.dto.faculty.FacultyCreateDTO;
import com.spring.students.dto.faculty.FacultyDTO;
import com.spring.students.dto.specialty.SpecialtyDTO;
import com.spring.students.entity.Faculty;
import com.spring.students.repositories.FacultyRepository;
import com.spring.students.services.FacultyService;
import com.spring.students.services.mapper.FacultyMapper;
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
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;
    private final SpecialtyMapper specialtyMapper;

    @Override
    @Transactional
    public FacultyDTO saveFaculty(FacultyCreateDTO faculty) {
        Faculty newFaculty = new Faculty(
                faculty.getName()
        );
        return facultyMapper.toDto(facultyRepository.save(newFaculty));
    }

    @Override
    public List<FacultyDTO> getAllFaculties() {
        return facultyMapper.toDtoList(facultyRepository.findAll());
    }

    @Override
    public FacultyDTO getByName(String name) {
        return facultyMapper.toDto(facultyRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("Faculty not found!")));
    }

    @Override
    public List<SpecialtyDTO> getSpecialties(String name) {
        return specialtyMapper.toDtoList(facultyRepository.findByName(name).orElseThrow().getSpecialties());
    }

    @Override
    @Transactional
    public FacultyDTO updateFaculty(Long id, FacultyCreateDTO faculty) {
        Faculty existing = facultyRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Faculty not found!"));
        existing.setName(faculty.getName());
        return facultyMapper.toDto(facultyRepository.saveAndFlush(existing));
    }

    @Override
    @Transactional
    public String deleteById(Long id) {
        facultyRepository.deleteById(id);
        return "Deleting was successful...";
    }

    @Override
    public List<FacultyDTO> download(List<FacultyDTO> data) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("info");
        HSSFRow rowhead = sheet.createRow(0);
        int col = 0;
        rowhead.createCell(col++).setCellValue("Номер");
        rowhead.createCell(col++).setCellValue("Название");
        for (FacultyDTO faculty: data) {
            HSSFRow row = sheet.createRow(data.indexOf(faculty)+1);
            col = 0;
            row.createCell(col++).setCellValue(faculty.getId());
            row.createCell(col++).setCellValue(faculty.getName());
        }
        FileOutputStream fileOut = new FileOutputStream("faculties.xls");
        workbook.write(fileOut);
        fileOut.close();
        return data;
    }
}
