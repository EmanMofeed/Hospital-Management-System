package com.example.Assignment1.service.impl;

import com.example.Assignment1.dto.PatientDto;
import com.example.Assignment1.entity.Appointment;
import com.example.Assignment1.entity.Doctor;
import com.example.Assignment1.entity.Patient;
import com.example.Assignment1.exception.ResourceNotFoundException;
import com.example.Assignment1.repository.PatientRepository;
import com.example.Assignment1.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public PatientDto createPatient(PatientDto patientDto) {

        // convert DTO to entity
        Patient patient = mapToEntity(patientDto);
        Patient newPatient = patientRepository.save(patient);

        // convert entity to DTO
        return mapToDTO(newPatient);
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto, int id) {
        // get patient by id from the database
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "patientId", id));

        patient.setName(patientDto.getName());
        patient.setName(patientDto.getName());
        patientDto.setName(patient.getName());
        patientDto.setGender(patient.getGender());
        patient.setPatientAge(patient.getPatientId());
        patient.setContactDetails(patient.getContactDetails());
        patient.setAppointments(patient.getAppointments());
        Patient updatedPatient = patientRepository.save(patient);
        return mapToDTO(updatedPatient);
    }

    @Override
    public void deletePatientById(int id) {
        // get Patient by id from the database
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "patientId", id));
        patientRepository.delete(patient);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(this::mapToDTO)
                .collect(Collectors.toList());    }
    @Override

    public Optional<Patient> getPatientById(int patientId) {
        return patientRepository.findById(patientId);
    }

    @Override
    public List<Patient> getPatientsByName(String name) {
        return patientRepository.findByName(name);
    }
    @Override
    public List<Patient> getPatientsByAgeGreaterThan(int age) {
        return patientRepository.findByPatientAgeGreaterThan(age);
    }
    @Override
    public Patient updatePatientName(int patientId, String newName) {
        Optional<Patient> existingPatient = patientRepository.findById(patientId);
        if (existingPatient.isPresent()) {
            Patient patient = existingPatient.get();
            patient.setName(newName);
            return patientRepository.save(patient);
        }
        return null;
    }
    @Override
    public Patient updatePatientAge(int patientId, int newAge) {
        Optional<Patient> existingPatient = patientRepository.findById(patientId);
        if (existingPatient.isPresent()) {
            Patient patient = existingPatient.get();
            patient.setPatientAge(newAge);
            return patientRepository.save(patient);
        }
        return null;
    }
    @Override
    public List<Appointment> getPatientAppointments(int patientId) {
        Optional<Patient> existingPatient = patientRepository.findById(patientId);
        if (existingPatient.isPresent()) {
            Patient patient = existingPatient.get();
            return patient.getAppointments();
        }
        return null;
    }

    // convert DTO to entity
    private Patient mapToEntity(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setGender(patientDto.getGender());
        patient.setPatientAge(patientDto.getPatientAge());
        patient.setContactDetails(patientDto.getContactDetails());
        patient.setAppointments(patientDto.getAppointments());
        return patient;
    }

    // convert Entity into DTO
    private PatientDto mapToDTO(Patient patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setPatientId(patient.getPatientId());
        patientDto.setName(patient.getName());
        patientDto.setGender(patient.getGender());
        patientDto.setPatientAge(patient.getPatientAge());
        patientDto.setContactDetails(patient.getContactDetails());
        patientDto.setAppointments(patient.getAppointments());
        return patientDto;
    }


}
