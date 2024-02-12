package com.freecodecamp.springBootJpa.DAL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freecodecamp.springBootJpa.DAL.entities.SchoolEntity;

public interface SchoolsRepository extends JpaRepository<SchoolEntity, Long> {

}
