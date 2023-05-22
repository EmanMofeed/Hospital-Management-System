package com.example.Assignment1.entity;


import jakarta.persistence.*;
import lombok.Data;
/* represents an entity in JPA, which is mapped to a database table. It is used to persist and retrieve data from the database.*/

@Entity
@Data
public class DoctorSpecialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "specialtyId")
    private Specialty specialty;
}

