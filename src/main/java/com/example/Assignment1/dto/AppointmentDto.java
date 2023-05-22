package com.example.Assignment1.dto;


import lombok.Data;

@Data
public class AppointmentDto {
    private int id;
    private DoctorDto doctor = new DoctorDto();
    private PatientDto patient = new PatientDto();

    public void setDoctor(int doctorId) {
        this.doctor.setDoctorId(doctorId);
    }

    public void setPatient(int patientId) {
        this.patient.setPatientId(patientId);
    }
}
