package com.example.Assignment1.entity;



import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
/* represents an entity in JPA, which is mapped to a database table. It is used to persist and retrieve data from the database.*/

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    @Column
    private String name;
    @Column
    private int patientAge;
    @Column
    private String gender;
    @Column
    private String contactDetails;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
