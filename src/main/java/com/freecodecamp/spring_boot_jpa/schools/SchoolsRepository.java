package com.freecodecamp.spring_boot_jpa.schools;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolsRepository extends JpaRepository<SchoolEntity, Long> {}
