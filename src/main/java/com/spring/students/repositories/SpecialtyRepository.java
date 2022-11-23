package com.spring.students.repositories;

import com.spring.students.entity.Faculty;
import com.spring.students.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    Specialty findByName(String name);
    List<Specialty> findByFaculty(Faculty faculty);
}
