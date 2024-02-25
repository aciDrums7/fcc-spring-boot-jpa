package com.freecodecamp.springBootJpa.students;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository
public interface StudentsRepository extends JpaRepository<StudentEntity, Long> {
    List<StudentEntity> findAllByFirstnameLike(
        /* @Param(value = "firstname") */String firstname
    );
}
