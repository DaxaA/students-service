package com.spring.students.repositories;

import com.spring.students.dto.SpecialtyDTO;
import com.spring.students.entity.Faculty;
import com.spring.students.entity.Specialty;
import com.spring.students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByName(String name);
}
