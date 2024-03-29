package com.freecodecamp.spring_boot_jpa.students;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.freecodecamp.spring_boot_jpa.schools.SchoolEntity;
import com.freecodecamp.spring_boot_jpa.studentsprofiles.StudentProfileEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
@Builder
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
    @JsonBackReference // ^ needed to avoid recursive loop reference when serializing to JSON
    private SchoolEntity school;
}
