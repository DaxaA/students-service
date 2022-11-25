package com.spring.students.repositories;

import com.spring.students.entity.Specialty;
import com.spring.students.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //по логике удобнее будет видеть итоги параллельно с каждой записью, чтобы сразу видеть отношение
    @Query(value = """
            select year as "Год", faculties.name as "Факультет",
            count(*) as "Кол-во студентов",
            sum(count()) over(partition by year) as "Итого за год",
            sum(count()) over() as "Итого поступивших"
            from students
            inner join specialties
            on students.specialty_id = specialties.id
            inner join faculties
            on specialties.faculty_id = faculties.id
            group by faculties.name, year
            order by year, faculties.name""", nativeQuery = true)
    List<Object[]> getCountByYearAndFaculty();
    Optional<List<Student>> findBySpecialty(Specialty specialty);
}
