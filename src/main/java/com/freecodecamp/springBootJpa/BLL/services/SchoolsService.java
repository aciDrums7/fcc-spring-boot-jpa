package com.freecodecamp.springBootJpa.BLL.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.freecodecamp.springBootJpa.BLL.dtos.schools.SchoolRequestDto;
import com.freecodecamp.springBootJpa.BLL.dtos.schools.SchoolResponseDto;
import com.freecodecamp.springBootJpa.BLL.exceptions.NoSuchElementFoundException;
import com.freecodecamp.springBootJpa.BLL.mappers.SchoolsMapper;
import com.freecodecamp.springBootJpa.DAL.entities.SchoolEntity;
import com.freecodecamp.springBootJpa.DAL.repositories.SchoolsRepository;

import lombok.AllArgsConstructor;

import static com.freecodecamp.springBootJpa.BLL.exceptions.NoSuchElementFoundException.elementNotFoundById;

@Service
@AllArgsConstructor
@SuppressWarnings("null")
public class SchoolsService {

    private final SchoolsRepository schoolRepository;

    private final SchoolsMapper schoolsMapper;

    public List<SchoolResponseDto> findAll() {
        return schoolsMapper.toResponseDtoList(schoolRepository.findAll());
    }

    public SchoolResponseDto findById(Long id) {
        return schoolsMapper
                .toResponseDto(
                        schoolRepository.findById(id).orElseThrow(
                                () -> new NoSuchElementFoundException(elementNotFoundById(id))));
    }

    public SchoolResponseDto create(SchoolRequestDto requestDto) {
        return schoolsMapper.toResponseDto(schoolRepository.save(schoolsMapper.toEntity(requestDto)));
    }

    public SchoolResponseDto update(Long id, SchoolRequestDto requestDto) throws NoSuchElementFoundException {
        if (schoolRepository.existsById(id)) {
            var schoolEntity = schoolsMapper.toEntity(requestDto);
            schoolEntity.setId(id);
            return schoolsMapper.toResponseDto(schoolRepository.save(schoolEntity));
        } else {
            throw new NoSuchElementFoundException(elementNotFoundById(id));
        }
    }

    public void delete(Long id) throws NoSuchElementFoundException {
        if (schoolRepository.existsById(id)) {
            schoolRepository.deleteById(id);
        } else {
            throw new NoSuchElementFoundException(elementNotFoundById(id));
        }
    }

}
