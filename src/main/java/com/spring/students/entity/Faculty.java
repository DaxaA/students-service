package com.spring.students.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "faculties")
public class Faculty {
    @Id
    @SequenceGenerator(name = "faculty_id_seq_generator",
            sequenceName = "faculty_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "faculty_id_seq_generator")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "faculty")
    private List<Specialty> specialties = new ArrayList<>();

    public Faculty(String name) {
        this.name = name;
    }
}
