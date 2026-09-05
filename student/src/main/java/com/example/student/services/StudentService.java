package com.example.student.services;

import com.example.student.Dto.StudentDTO;
import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.services.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    public Student save (StudentDTO studentDTO) {
        Student student = mapper.toStudent(studentDTO);
        studentRepository.save(student);
        return student;
    }

    public List<StudentDTO> findAll() {
        var students = studentRepository.findAll();
        return students.stream().map(mapper::toStudentDTO).toList();
    }

    public List<StudentDTO> findBySchoolId(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
