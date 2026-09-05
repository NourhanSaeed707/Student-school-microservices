package com.example.student.repository;

import com.example.student.Dto.StudentDTO;
import com.example.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<StudentDTO> findAllBySchoolId(Integer schoolId);
}
