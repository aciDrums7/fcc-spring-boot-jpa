package com.freecodecamp.springBootJpa.schools;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolsRepository extends JpaRepository<SchoolEntity, Long> {}
