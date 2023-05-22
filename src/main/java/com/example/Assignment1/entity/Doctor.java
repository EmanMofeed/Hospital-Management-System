package com.example.Assignment1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
/* represents an entity in JPA, which is mapped to a database table. It is used to persist and retrieve data from the database.*/


@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue
    private int doctorId;

    @Column
    private String name;

    @Column
    private String specialty;

    @Column
    private String schedule;

}
