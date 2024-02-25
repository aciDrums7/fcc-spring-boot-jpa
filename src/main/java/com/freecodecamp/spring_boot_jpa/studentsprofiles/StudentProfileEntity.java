package com.freecodecamp.spring_boot_jpa.studentsprofiles;

import com.freecodecamp.spring_boot_jpa.students.StudentEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "students_profiles")
@Data
public class StudentProfileEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String bio;

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;
}
