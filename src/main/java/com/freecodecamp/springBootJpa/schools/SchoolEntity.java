package com.freecodecamp.springBootJpa.schools;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.freecodecamp.springBootJpa.students.StudentEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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

    @OneToMany(mappedBy = "school"/* , fetch = FetchType.EAGER */)
    @JsonManagedReference // ^ needed to avoid recursive loop reference when serializing to JSON
    private List<StudentEntity> students;
}
