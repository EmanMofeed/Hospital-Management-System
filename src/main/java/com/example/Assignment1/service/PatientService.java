package com.example.Assignment1.service;

import com.example.Assignment1.dto.PatientDto;
import com.example.Assignment1.entity.Appointment;
import com.example.Assignment1.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    PatientDto createPatient(PatientDto patientDto);

    List<PatientDto> getAllPatients();

    Optional<Patient> getPatientById(int id);

    PatientDto updatePatient(PatientDto patientDto, int id);

    void deletePatientById(int id);
    List<Patient>getPatientsByName(String name);
     List<Patient> getPatientsByAgeGreaterThan(int age);
     Patient updatePatientName(int patientId, String newName);
     Patient updatePatientAge(int patientId, int newAge);
     List<Appointment> getPatientAppointments(int patientId);

    }
