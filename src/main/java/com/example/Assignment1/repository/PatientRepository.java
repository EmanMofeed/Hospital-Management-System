package com.example.Assignment1.repository;

import com.example.Assignment1.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The repository interface for accessing and managing Patient entities.
 * It provides methods to perform CRUD operations and additional querying capabilities on the Patient entity.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByName(String name);

    List<Patient> findByPatientAgeGreaterThan(int age);

}