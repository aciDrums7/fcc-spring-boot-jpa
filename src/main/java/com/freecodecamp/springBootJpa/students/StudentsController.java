package com.freecodecamp.springBootJpa.students;

import jakarta.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<StudentResponseDto> create(@NonNull @Valid @RequestBody StudentRequestDto requestDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("")).body(studentsService.create(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> update(
        @NonNull @PathVariable Long id,
        @NonNull @Valid @RequestBody StudentRequestDto requestDto
    ) {
        return ResponseEntity.ok(studentsService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponseDto> delete(@NonNull @PathVariable Long id) {
        studentsService.delete(id);
        return ResponseEntity.noContent().build();
    }
    // ^ Custom way to handle web exceptions
    /*
     * @ExceptionHandler(MethodArgumentNotValidException.class)
     * public ResponseEntity<HashMap<String, String>>
     * handleMethodArgumentNotValidException(
     * MethodArgumentNotValidException exc) {
     * var errors = new HashMap<String, String>();
     * exc.getBindingResult().getAllErrors().forEach(error -> {
     * var key = ((FieldError) error).getField();
     * var message = error.getDefaultMessage();
     * errors.put(key, message);
     * });
     * return ResponseEntity.badRequest().body(errors);
     * }
     */
}
