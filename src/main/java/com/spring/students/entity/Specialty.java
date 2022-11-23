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
@Table(name = "specialties")
public class Specialty {
    @Id
    @SequenceGenerator(name = "specialty_id_seq_generator",
            sequenceName = "specialty_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "specialty_id_seq_generator")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "specialty")
    private List<Student> students = new ArrayList<>();

    public Specialty(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }
}
