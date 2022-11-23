package com.spring.students.repositories;

import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.entity.Specialty;
import com.spring.students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String name);
    List<Student> findBySpecialty(Specialty specialty);
}
