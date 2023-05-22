package com.example.Assignment1.dto;

import com.example.Assignment1.entity.Appointment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
    public class PatientDto {
        private int patientId;
        private String name;
        private int patientAge;
        private String gender;
        private String contactDetails;
    @JsonIgnore
    private List<Appointment> appointments;

}
