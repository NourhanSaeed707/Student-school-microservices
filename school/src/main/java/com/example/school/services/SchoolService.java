package com.example.school.services;
import com.example.school.Dtos.SchoolDTO;
import com.example.school.entity.School;
import com.example.school.repository.SchoolRepository;
import com.example.school.services.mapper.SchoolMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper mapper;

    public School save(SchoolDTO schoolDTO) {
        School school = mapper.toSchool(schoolDTO);
        return schoolRepository.save(school);
    }

    public List<SchoolDTO> findAll () {
        var schools =  schoolRepository.findAll();
        return schools.stream().map(mapper::toSchoolDTO).toList();
    }
}
