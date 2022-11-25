package com.spring.students.repositories;

import com.spring.students.entity.Specialty;
import com.spring.students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByName(String name);
    Optional<List<Student>> findBySpecialty(Specialty specialty);
}
