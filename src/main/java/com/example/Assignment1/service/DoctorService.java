package com.example.Assignment1.service;


import com.example.Assignment1.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto createDoctor(DoctorDto doctorDto);

    List<DoctorDto> getAllDoctors();

    DoctorDto getDoctorById(int id);

    DoctorDto updateDoctor(DoctorDto doctorDto, int id);

    void deleteDoctorById(int id);
}

