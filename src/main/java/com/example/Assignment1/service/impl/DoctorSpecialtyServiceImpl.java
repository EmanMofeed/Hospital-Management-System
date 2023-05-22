package com.example.Assignment1.service.impl;

import com.example.Assignment1.dto.DoctorDto;
import com.example.Assignment1.dto.DoctorSpecialtyDto;
import com.example.Assignment1.dto.SpecialtyDto;
import com.example.Assignment1.entity.Doctor;
import com.example.Assignment1.entity.DoctorSpecialty;
import com.example.Assignment1.entity.Specialty;
import com.example.Assignment1.exception.ResourceNotFoundException;
import com.example.Assignment1.repository.DoctorSpecialtyRepository;
import com.example.Assignment1.service.DoctorSpecialtyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorSpecialtyServiceImpl implements DoctorSpecialtyService {

    private DoctorSpecialtyRepository doctorSpecialtyRepository;

    public DoctorSpecialtyServiceImpl(DoctorSpecialtyRepository doctorSpecialtyRepository) {
        this.doctorSpecialtyRepository = doctorSpecialtyRepository;
    }

    @Override
    public DoctorSpecialtyDto createDoctorSpecialty(DoctorSpecialtyDto doctorSpecialtyDto) {
        // Convert DTO to entity
        DoctorSpecialty doctorSpecialty = mapToEntity(doctorSpecialtyDto);
        DoctorSpecialty newDoctorSpecialty = doctorSpecialtyRepository.save(doctorSpecialty);

        // Convert entity to DTO
        return mapToDto(newDoctorSpecialty);
    }

    @Override
    public List<DoctorSpecialtyDto> getAllDoctorSpecialties() {
        List<DoctorSpecialty> doctorSpecialties = doctorSpecialtyRepository.findAll();
        return doctorSpecialties.stream().map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorSpecialtyDto getDoctorSpecialtyById(int id) {
        DoctorSpecialty doctorSpecialty = doctorSpecialtyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DoctorSpecialty", "id", id));
        return mapToDto(doctorSpecialty);
    }

    @Override
    public DoctorSpecialtyDto updateDoctorSpecialty(DoctorSpecialtyDto doctorSpecialtyDto, int id) {
        DoctorSpecialty existingDoctorSpecialty = doctorSpecialtyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DoctorSpecialty", "id", id));

        // Update the properties of existingDoctorSpecialty with the values from doctorSpecialtyDto

        DoctorSpecialty updatedDoctorSpecialty = doctorSpecialtyRepository.save(existingDoctorSpecialty);
        return mapToDto(updatedDoctorSpecialty);
    }

    @Override
    public void deleteDoctorSpecialtyById(int id) {
        DoctorSpecialty doctorSpecialty = doctorSpecialtyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DoctorSpecialty", "id", id));
        doctorSpecialtyRepository.delete(doctorSpecialty);
    }

    private DoctorSpecialty mapToEntity(DoctorSpecialtyDto doctorSpecialtyDto) {
        DoctorSpecialty doctorSpecialty = new DoctorSpecialty();

        DoctorDto doctorDto = doctorSpecialtyDto.getDoctor();
        if (doctorDto != null) {
            Doctor doctor = new Doctor();
            doctor.setDoctorId(doctorDto.getDoctorId());
            // Set other properties of Doctor as needed

            doctorSpecialty.setDoctor(doctor);
        }

        SpecialtyDto specialtyDto = doctorSpecialtyDto.getSpecialty();
        if (specialtyDto != null) {
            Specialty specialty = new Specialty();
            specialty.setSpecialtyId(specialtyDto.getSpecialtyId());
            // Set other properties of Specialty as needed

            doctorSpecialty.setSpecialty(specialty);
        }

        return doctorSpecialty;
    }

    private DoctorSpecialtyDto mapToDto(DoctorSpecialty doctorSpecialty) {
        DoctorSpecialtyDto doctorSpecialtyDto = new DoctorSpecialtyDto();
        doctorSpecialtyDto.setId(doctorSpecialty.getId());

        Doctor doctor = doctorSpecialty.getDoctor();
        if (doctor != null) {
            DoctorDto doctorDto = new DoctorDto();
            doctorDto.setDoctorId(doctor.getDoctorId());
            doctorDto.setName(doctor.getName());
            doctorDto.setSpecialty(doctor.getSpecialty());
            doctorDto.setSchedule(doctor.getSchedule());
            doctorSpecialtyDto.setDoctor(doctorDto);
        }

        Specialty specialty = doctorSpecialty.getSpecialty();
        if (specialty != null) {
            SpecialtyDto specialtyDto = new SpecialtyDto();
            specialtyDto.setSpecialtyId(specialty.getSpecialtyId());
            specialtyDto.setName(specialty.getName());
            doctorSpecialtyDto.setSpecialty(specialtyDto);
        }

        return doctorSpecialtyDto;
    }



}

