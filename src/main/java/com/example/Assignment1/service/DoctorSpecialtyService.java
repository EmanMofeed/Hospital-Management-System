package com.example.Assignment1.service;

import com.example.Assignment1.dto.DoctorSpecialtyDto;

import java.util.List;

public interface DoctorSpecialtyService {

    DoctorSpecialtyDto createDoctorSpecialty(DoctorSpecialtyDto doctorSpecialtyDto);

    List<DoctorSpecialtyDto> getAllDoctorSpecialties();

    DoctorSpecialtyDto getDoctorSpecialtyById(int id);

    DoctorSpecialtyDto updateDoctorSpecialty(DoctorSpecialtyDto doctorSpecialtyDto, int id);

    void deleteDoctorSpecialtyById(int id);
}

