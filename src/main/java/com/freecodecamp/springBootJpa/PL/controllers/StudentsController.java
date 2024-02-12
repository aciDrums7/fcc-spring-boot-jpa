package com.freecodecamp.springBootJpa.PL.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

import com.freecodecamp.springBootJpa.BLL.dtos.students.StudentRequestDto;
import com.freecodecamp.springBootJpa.BLL.dtos.students.StudentResponseDto;
import com.freecodecamp.springBootJpa.BLL.services.StudentsService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentsController {

    private final StudentsService studentsService;

    @GetMapping("/")
    public ResponseEntity<List<StudentResponseDto>> findAll() {
        return ResponseEntity.ok(studentsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> findById(@NonNull @PathVariable Long id) {
        return ResponseEntity.ok(studentsService.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<StudentResponseDto>> findAllByFirstname(@NonNull @RequestParam String firstname) {
        return ResponseEntity.ok(studentsService.findAllByFirstname(firstname));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentResponseDto> create(@NonNull @RequestBody StudentRequestDto requestDto)
            throws URISyntaxException {
        return ResponseEntity.created(new URI("")).body(studentsService.create(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> update(@NonNull @PathVariable Long id,
            @NonNull @RequestBody StudentRequestDto requestDto) {
        return ResponseEntity.ok(studentsService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponseDto> delete(@NonNull @PathVariable Long id) {
        studentsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
