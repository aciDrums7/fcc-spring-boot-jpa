package com.freecodecamp.springBootJpa.students;

import static com.freecodecamp.springBootJpa.misc.exceptions.NoSuchElementFoundException.elementNotFoundById;

import com.freecodecamp.springBootJpa.misc.exceptions.NoSuchElementFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        return studentsMapper.toResponseDto(
            studentsRepository.findById(id).orElseThrow(() -> new NoSuchElementFoundException(elementNotFoundById(id)))
        );
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
