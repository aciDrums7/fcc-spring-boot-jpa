package com.freecodecamp.spring_boot_jpa.DAL.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "schools")
@Data
public class SchoolEntity {

    @Id
    @GeneratedValue
    private Long id;

    // @Column
    private String name;

    @OneToMany(mappedBy = "school")
    private List<StudentEntity> students;
}
