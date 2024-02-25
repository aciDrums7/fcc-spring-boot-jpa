package com.freecodecamp.springBootJpa.students;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.freecodecamp.springBootJpa.schools.SchoolsRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@SuppressWarnings("null")
class StudentsServiceTest {

    @Mock
    private StudentsRepository studentsRepository;

    @Mock
    private StudentsMapper studentsMapper;

    @Mock
    private SchoolsRepository schoolsRepository;

    @InjectMocks
    private StudentsService service;

    private StudentRequestDto mockRequestDto;
    private StudentEntity mockEntity;
    private StudentResponseDto mockResponseDto;

    // @BeforeAll
    // static void beforeAll() {
    //     System.out.println("Inside beforeAll");
    // }

    // @AfterAll
    // static void afterAll() {
    //     System.out.println("Inside afterAll");
    // }

    @BeforeEach
    void beforeEach() {
        System.out.println("Inside beforeEach");
        //^ needed to instantiate the mocks
        MockitoAnnotations.openMocks(this);

        mockRequestDto =
            StudentRequestDto
                .builder()
                .firstname("Edoardo")
                .lastname("Carradori")
                .email("edoardo.carradori.96@gmail.com")
                .age(27)
                .build();

        mockEntity =
            StudentEntity
                .builder()
                .firstname("Edoardo")
                .lastname("Carradori")
                .email("edoardo.carradori.96@gmail.com")
                .age(27)
                .build();

        mockResponseDto =
            StudentResponseDto
                .builder()
                .firstname("Edoardo")
                .lastname("Carradori")
                .email("edoardo.carradori.96@gmail.com")
                .age(27)
                .build();
    }

    // @AfterEach
    // void afterEach() {
    //     System.out.println("Inside afterEach");
    // }

    @Test
    void should_find_all_students() {
        // Arrange
        List<StudentEntity> mockEntitiesList = List.of(mockEntity);

        // Mocked calls
        when(studentsRepository.findAll()).thenReturn(mockEntitiesList);
        when(studentsMapper.toDto(mockEntity)).thenReturn(mockResponseDto);

        // Act
        var responseDtoList = service.findAll();

        // Assert
        assertEquals(mockEntitiesList.size(), responseDtoList.size());

        verify(studentsRepository, times(1)).findAll();
        verify(studentsMapper, times(1)).toDto(any(StudentEntity.class));
    }

    @Test
    void should_find_student_by_id() {
        // Arrange
        Long studentId = 1L;

        // Mocked calls
        when(studentsRepository.findById(studentId))
            .thenReturn(Optional.of(mockEntity));
        when(studentsMapper.toDto(mockEntity)).thenReturn(mockResponseDto);

        // Act
        var responseDto = service.findById(studentId);

        // Assert
        assertEquals(mockRequestDto.firstname(), responseDto.firstname());
        assertEquals(mockRequestDto.lastname(), responseDto.lastname());
        assertEquals(mockRequestDto.email(), responseDto.email());
        assertEquals(mockRequestDto.age(), responseDto.age());

        verify(studentsRepository, times(1)).findById(studentId);
        verify(studentsMapper, times(1)).toDto(mockEntity);
    }

    @Test
    void should_find_all_students_by_firstname() {
        // Arrange
        String firstname = "Edoardo";
        List<StudentEntity> mockEntitiesList = List.of(mockEntity);

        // Mocked calls
        when(studentsRepository.findAllByFirstnameLike(firstname))
            .thenReturn(mockEntitiesList);
        when(studentsMapper.toDto(mockEntity)).thenReturn(mockResponseDto);

        // Act
        var responseDtoList = service.findAllByFirstname(firstname);

        // Assert
        assertEquals(mockEntitiesList.size(), responseDtoList.size());

        verify(studentsRepository, times(1))
            .findAllByFirstnameLike(anyString());
        verify(studentsMapper, times(1)).toDto(any(StudentEntity.class));
    }

    @Test
    void should_save_a_student() {
        // Arrange

        // Mocked calls
        when(studentsMapper.toEntity(mockRequestDto)).thenReturn(mockEntity);
        when(studentsRepository.save(mockEntity)).thenReturn(mockEntity);
        when(studentsMapper.toDto(mockEntity)).thenReturn(mockResponseDto);

        // Act
        var responseDto = service.create(mockRequestDto);

        // Assert
        assertEquals(mockRequestDto.firstname(), responseDto.firstname());
        assertEquals(mockRequestDto.lastname(), responseDto.lastname());
        assertEquals(mockRequestDto.email(), responseDto.email());
        assertEquals(mockRequestDto.age(), responseDto.age());

        verify(studentsMapper, times(1)).toEntity(mockRequestDto);
        verify(studentsRepository, times(1)).save(mockEntity);
        verify(studentsMapper, times(1)).toDto(mockEntity);
    }
}
