package com.freecodecamp.spring_boot_jpa.DAL.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue
    private Long id;

    // @Column
    private String firstname;

    // @Column
    private String lastname;

    @Column(unique = true, length = 127)
    private String email;

    // @Column
    private Integer age;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentProfileEntity studentProfile;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;
}
