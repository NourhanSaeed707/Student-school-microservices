package com.example.school.controllers;
import com.example.school.Dtos.FullSchoolResponse;
import com.example.school.Dtos.SchoolDTO;
import com.example.school.entity.School;
import com.example.school.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schools")
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping("/")
    public ResponseEntity<School> save(@RequestBody SchoolDTO schoolDTO) {
        var school =  schoolService.save(schoolDTO);
        return ResponseEntity.ok(school);
    }

    @GetMapping("/")
    public ResponseEntity<List<SchoolDTO>> findAll() {
        var schools = schoolService.findAll();
        return ResponseEntity.ok(schools);
    }

    @GetMapping("/with-students/{schoolId}")
    public ResponseEntity<FullSchoolResponse> findBySchoolId(@PathVariable Integer schoolId) {
        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
    }

}
