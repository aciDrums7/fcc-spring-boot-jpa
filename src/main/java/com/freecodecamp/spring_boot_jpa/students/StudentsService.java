package com.freecodecamp.spring_boot_jpa.students;

import static com.freecodecamp.spring_boot_jpa.misc.exceptions.NoSuchElementFoundException.elementNotFoundById;

import com.freecodecamp.spring_boot_jpa.misc.exceptions.NoSuchElementFoundException;
import com.freecodecamp.spring_boot_jpa.schools.SchoolEntity;
import com.freecodecamp.spring_boot_jpa.schools.SchoolsRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@SuppressWarnings("null")
public class StudentsService {

    private final StudentsRepository studentsRepository;

    private final SchoolsRepository schoolsRepository;

    private final StudentsMapper studentsMapper;

    public List<StudentResponseDto> findAll() {
        return studentsRepository
            .findAll()
            .stream()
            .map(studentsMapper::toDto)
            .toList();
    }

    public List<StudentResponseDto> findAllByFirstname(String firstname) {
        return studentsRepository
            .findAllByFirstnameLike(firstname)
            .stream()
            .map(studentsMapper::toDto)
            .toList();
    }

    public StudentResponseDto findById(Long id) {
        return studentsRepository
            .findById(id)
            .map(studentsMapper::toDto)
            .orElseThrow(() ->
                new NoSuchElementFoundException(elementNotFoundById(id))
            );
    }

    public StudentResponseDto create(StudentRequestDto requestDto) {
        Optional<SchoolEntity> schoolEntity = Optional.empty();
        if (requestDto.schoolId() != null) {
            schoolEntity = schoolsRepository.findById(requestDto.schoolId());
        }
        var studentEntity = studentsMapper.toEntity(requestDto);
        studentEntity.setSchool(schoolEntity.orElse(null));
        return studentsMapper.toDto(studentsRepository.save(studentEntity));
    }

    public StudentResponseDto update(Long id, StudentRequestDto requestDto) {
        if (studentsRepository.existsById(id)) {
            var studentEntity = studentsMapper.toEntity(requestDto);
            studentEntity.setId(id);
            return studentsMapper.toDto(studentsRepository.save(studentEntity));
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
