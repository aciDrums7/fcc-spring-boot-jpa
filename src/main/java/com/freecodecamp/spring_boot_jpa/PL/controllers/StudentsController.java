package com.freecodecamp.spring_boot_jpa.PL.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.freecodecamp.spring_boot_jpa.DAL.entities.StudentEntity;
import com.freecodecamp.spring_boot_jpa.DAL.repositories.StudentsRepository;

@RestController
@RequestMapping("/students")
public class StudentsController {

    private final StudentsRepository studentsRepository;

    public StudentsController(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @GetMapping("")
    public List<StudentEntity> findAll() {
        return studentsRepository.findAll();
    }

    @GetMapping("/{id}")
    public StudentEntity findById(@NonNull @PathVariable Long id) {
        return studentsRepository.findById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<StudentEntity> findAllByFirstname(@NonNull @RequestParam String firstname) {
        return studentsRepository.findAllByFirstnameLike(firstname);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentEntity save(@NonNull @RequestBody StudentEntity studentEntity) {
        return studentsRepository.save(studentEntity);
    }

    @PutMapping("/{id}")
    public StudentEntity update(@NonNull @PathVariable Long id,
            @NonNull @RequestBody StudentEntity studentEntity) {
        if (studentsRepository.existsById(id)) {
            studentEntity.setId(id);
            return studentsRepository.save(studentEntity);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@NonNull @PathVariable Long id) {
        if (studentsRepository.existsById(id)) {
            studentsRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
