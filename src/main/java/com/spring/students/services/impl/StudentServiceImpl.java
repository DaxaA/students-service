package com.spring.students.services.impl;

import com.spring.students.dto.student.StudentCreateDTO;
import com.spring.students.dto.student.StudentDTO;
import com.spring.students.entity.Student;
import com.spring.students.repositories.SpecialtyRepository;
import com.spring.students.repositories.StudentRepository;
import com.spring.students.services.StudentService;
import com.spring.students.services.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFCell;
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
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SpecialtyRepository specialtyRepository;
    private final StudentMapper studentMapper;

    @Override
    @Transactional
    public StudentDTO saveStudent(StudentCreateDTO student) {
        Student newStudent = new Student(
                student.getName(),
                student.getPhone(),
                student.getAddress(),
                student.getYear(),
                specialtyRepository.findByName(student.getSpecialty()).orElseThrow(() -> new NoSuchElementException("Specialty not found!"))
        );
        return studentMapper.toDto(studentRepository.save(newStudent));
    }

    @Override
    public List<StudentDTO> getStudents() {
        return studentMapper.toDtoList(studentRepository.findAll());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        return studentMapper.toDto(studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Student with id " + id + " not found!")));
    }

    @Override
    @Transactional
    public StudentDTO updateStudent(Long id, StudentCreateDTO student) {
        Student existing = studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Student not found!"));
        existing.setName(student.getName());
        existing.setPhone(student.getPhone());
        existing.setAddress(student.getAddress());
        existing.setYear(student.getYear());
        existing.setSpecialty(specialtyRepository.findByName(student.getName()).orElseThrow(() -> new NoSuchElementException("Specialty not found!")));
        return studentMapper.toDto(studentRepository.saveAndFlush(existing));
    }

    @Override
    @Transactional
    public String deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return "Deleting was successful...";
    }

    @Override
    public List<StudentDTO> getStudentsBySpecialty(String specialty){
        return studentMapper.toDtoList(
                studentRepository.findBySpecialty(
                        specialtyRepository.findByName(specialty)
                                .orElseThrow(() -> new NoSuchElementException("Specialty not found!")))
                        .orElseThrow(() -> new NoSuchElementException("Students not found!")));
    }

    @Override
    public List<StudentDTO> download(List<StudentDTO> data) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("info");
        HSSFRow rowhead = sheet.createRow(0);
        int col = 0;
        rowhead.createCell(col++).setCellValue("??????????");
        rowhead.createCell(col++).setCellValue("??????");
        rowhead.createCell(col++).setCellValue("??????????????");
        rowhead.createCell(col++).setCellValue("??????????");
        rowhead.createCell(col++).setCellValue("?????? ??????????????????????");
        rowhead.createCell(col++).setCellValue("??????????????????????????");
        for (StudentDTO student: data) {
            HSSFRow row = sheet.createRow(data.indexOf(student)+1);
            col = 0;
            row.createCell(col++).setCellValue(student.getId());
            row.createCell(col++).setCellValue(student.getName());
            row.createCell(col++).setCellValue(student.getPhone());
            row.createCell(col++).setCellValue(student.getAddress());
            row.createCell(col++).setCellValue(student.getYear());
            row.createCell(col++).setCellValue(student.getSpecialty());
        }
        FileOutputStream fileOut = new FileOutputStream("students.xls");
        workbook.write(fileOut);
        fileOut.close();
        return data;
    }

    @Override
    public List<Object[]> report() throws IOException {
        List<Object[]> data = studentRepository.getCountByYearAndFaculty();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("info");
        HSSFRow rowhead = sheet.createRow(0);
        rowhead.createCell((short) 0).setCellValue("??????");
        rowhead.createCell((short) 1).setCellValue("??????????????????");
        rowhead.createCell((short) 2).setCellValue("??????-???? ??????????????????????");
        rowhead.createCell((short) 3).setCellValue("?????????? ???? ??????");
        rowhead.createCell((short) 4).setCellValue("?????????? ??????????????????????");
        for (Object[] object: data) {
            HSSFRow row = sheet.createRow(data.indexOf(object)+1);
            int colnum = 0;
            for (Object col: object) {
                HSSFCell cell = row.createCell(colnum++);
                cell.setCellValue(col.toString());
            }
        }
        FileOutputStream fileOut = new FileOutputStream("report.xls");
        workbook.write(fileOut);
        fileOut.close();
        return data;
    }
}
