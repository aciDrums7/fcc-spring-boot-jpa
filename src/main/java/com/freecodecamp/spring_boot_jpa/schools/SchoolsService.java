package com.freecodecamp.spring_boot_jpa.schools;

import static com.freecodecamp.spring_boot_jpa.misc.exceptions.NoSuchElementFoundException.elementNotFoundById;

import com.freecodecamp.spring_boot_jpa.misc.exceptions.NoSuchElementFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@SuppressWarnings("null")
public class SchoolsService {

    private final SchoolsRepository schoolRepository;

    private final SchoolsMapper schoolMapper;

    public List<SchoolResponseDto> findAll() {
        return schoolRepository
            .findAll()
            .stream()
            .map(schoolMapper::toDto)
            .toList();
    }

    public SchoolResponseDto findById(Long id) {
        return schoolRepository
            .findById(id)
            .map(schoolMapper::toDto)
            .orElseThrow(() ->
                new NoSuchElementFoundException(elementNotFoundById(id))
            );
    }

    public SchoolResponseDto create(SchoolRequestDto requestDto) {
        return schoolMapper.toDto(
            schoolRepository.save(schoolMapper.toEntity(requestDto))
        );
    }

    public SchoolResponseDto update(Long id, SchoolRequestDto requestDto)
        throws NoSuchElementFoundException {
        if (schoolRepository.existsById(id)) {
            var schoolEntity = schoolMapper.toEntity(requestDto);
            schoolEntity.setId(id);
            return schoolMapper.toDto(schoolRepository.save(schoolEntity));
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
