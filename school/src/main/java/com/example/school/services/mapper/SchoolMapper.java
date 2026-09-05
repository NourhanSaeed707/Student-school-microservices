package com.example.school.services.mapper;

import com.example.school.Dtos.SchoolDTO;
import com.example.school.entity.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toSchool(SchoolDTO schoolDTO) {
        return School.builder()
                .name(schoolDTO.getName())
                .email(schoolDTO.getEmail())
                .build();
    }

    public SchoolDTO toSchoolDTO(School school) {
        return SchoolDTO.builder()
                .name(school.getName())
                .email(school.getEmail())
                .build();
    }
}
