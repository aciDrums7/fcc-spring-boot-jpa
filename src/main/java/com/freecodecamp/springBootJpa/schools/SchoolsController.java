package com.freecodecamp.springBootJpa.schools;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/schools")
public class SchoolsController {

    private final SchoolsService schoolsService;

    @GetMapping("/")
    public ResponseEntity<List<SchoolResponseDto>> findAll() {
        return ResponseEntity.ok(schoolsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolResponseDto> findById(
        @NonNull @PathVariable Long id
    ) {
        return ResponseEntity.ok(schoolsService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<SchoolResponseDto> create(
        @NonNull @RequestBody SchoolRequestDto requestDto
    ) throws URISyntaxException {
        return ResponseEntity
            .created(new URI(""))
            .body(schoolsService.create(requestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolResponseDto> update(
        @NonNull @PathVariable Long id,
        @NonNull @RequestBody SchoolRequestDto requestDto
    ) {
        return ResponseEntity.ok(schoolsService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@NonNull @PathVariable Long id) {
        schoolsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
