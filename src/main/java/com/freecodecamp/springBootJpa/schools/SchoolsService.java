package com.freecodecamp.springBootJpa.schools;

import static com.freecodecamp.springBootJpa.misc.exceptions.NoSuchElementFoundException.elementNotFoundById;

import com.freecodecamp.springBootJpa.misc.exceptions.NoSuchElementFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        return schoolsMapper.toResponseDto(
            schoolRepository.findById(id).orElseThrow(() -> new NoSuchElementFoundException(elementNotFoundById(id)))
        );
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
