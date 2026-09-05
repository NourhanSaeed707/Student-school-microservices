package com.example.student.services.mapper;

import com.example.student.Dto.StudentDTO;
import com.example.student.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public StudentDTO toStudentDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .build();
    }

    public Student toStudent(StudentDTO studentDTO) {
        return Student.builder()
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .email(studentDTO.getEmail())
                .build();
    }
}
