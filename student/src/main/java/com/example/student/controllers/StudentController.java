package com.example.student.controllers;

import com.example.student.Dto.StudentDTO;
import com.example.student.entity.Student;
import com.example.student.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<Student> save(@RequestBody StudentDTO studentDTO) {
        var student =  studentService.save(studentDTO);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentDTO>> findAll() {
        var students = studentService.findAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<StudentDTO>> findBySchoolId(@PathVariable Integer schoolId) {
        return ResponseEntity.ok(studentService.findBySchoolId(schoolId));
    }
}
