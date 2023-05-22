package com.example.Assignment1.service.impl;

import com.example.Assignment1.dto.DoctorDto;
import com.example.Assignment1.entity.Doctor;
import com.example.Assignment1.exception.ResourceNotFoundException;
import com.example.Assignment1.repository.DoctorRepository;
import com.example.Assignment1.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {


    private DoctorRepository doctorRepository;
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {

        // convert DTO to entity
        Doctor doctor = mapToEntity(doctorDto);
        Doctor newDoctor = doctorRepository.save(doctor);

        // convert entity to DTO
        DoctorDto doctorResponse = mapToDTO(newDoctor);
        return doctorResponse;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDto getDoctorById(int id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor", "doctorId", id));
        return mapToDTO(doctor);
    }

   @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto, int id) {
        // get doctor by id from the database
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor", "doctorId", id));

       doctor.setName(doctorDto.getName());
       doctor.setSpecialty(doctorDto.getSpecialty());
       doctor.setSchedule(doctorDto.getSchedule());
        Doctor updatedDoctor = doctorRepository.save(doctor);
        return mapToDTO(updatedDoctor);
    }

    @Override
    public void deleteDoctorById(int id) {
        // get doctor by id from the database
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor", "doctorId", id));
        doctorRepository.delete(doctor);
    }

    // convert DTO to entity
    private Doctor mapToEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setSpecialty(doctorDto.getSpecialty());
        doctor.setSchedule(doctorDto.getSchedule());
        return doctor;
    }

    // convert Entity into DTO
    private DoctorDto mapToDTO(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setDoctorId(doctor.getDoctorId());
        doctorDto.setName(doctor.getName());
        doctorDto.setSpecialty(doctor.getSpecialty());
        doctorDto.setSchedule(doctor.getSchedule());
        return doctorDto;
    }

}

