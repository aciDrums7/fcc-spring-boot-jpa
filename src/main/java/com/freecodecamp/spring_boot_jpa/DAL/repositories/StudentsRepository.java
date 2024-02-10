package com.freecodecamp.spring_boot_jpa.DAL.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freecodecamp.spring_boot_jpa.DAL.entities.StudentEntity;

// @Repository
public interface StudentsRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findAllByFirstnameLike(/* @Param(value = "firstname") */ String firstname);
}
