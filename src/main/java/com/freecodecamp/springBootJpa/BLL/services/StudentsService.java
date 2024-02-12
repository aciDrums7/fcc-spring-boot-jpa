package com.freecodecamp.springBootJpa.BLL.services;

import static com.freecodecamp.springBootJpa.BLL.exceptions.NoSuchElementFoundException.elementNotFoundById;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.freecodecamp.springBootJpa.BLL.dtos.students.StudentRequestDto;
import com.freecodecamp.springBootJpa.BLL.dtos.students.StudentResponseDto;
import com.freecodecamp.springBootJpa.BLL.exceptions.NoSuchElementFoundException;
import com.freecodecamp.springBootJpa.BLL.mappers.StudentsMapper;
import com.freecodecamp.springBootJpa.DAL.entities.StudentEntity;
import com.freecodecamp.springBootJpa.DAL.repositories.StudentsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@SuppressWarnings("null")
public class StudentsService {

    private final StudentsRepository studentsRepository;

    private final StudentsMapper studentsMapper;

    public List<StudentResponseDto> findAll() {
        return studentsMapper.toResponseDtoList(studentsRepository.findAll());
    }

    public List<StudentResponseDto> findAllByFirstname(String firstname) {
        return studentsMapper.toResponseDtoList(studentsRepository.findAllByFirstnameLike(firstname));
    }

    public StudentResponseDto findById(Long id) {
        return studentsMapper.toResponseDto(studentsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(elementNotFoundById(id))));
    }

    public StudentResponseDto create(StudentRequestDto requestDto) {
        return studentsMapper.toResponseDto(studentsRepository.save(studentsMapper.toEntity(requestDto)));
    }

    public StudentResponseDto update(Long id, StudentRequestDto requestDto) {
        if (studentsRepository.existsById(id)) {
            var studentEntity = studentsMapper.toEntity(requestDto);
            studentEntity.setId(id);
            return studentsMapper.toResponseDto(studentsRepository.save(studentEntity));
        } else {
            throw new NoSuchElementFoundException(elementNotFoundById(id));
        }
    }

    public void delete(Long id) {
        if (studentsRepository.existsById(id)) {
            studentsRepository.deleteById(id);
        } else {
            throw new NoSuchElementFoundException(elementNotFoundById(id));
        }
    }

}
