package com.example.Assignment1.repository;

import com.example.Assignment1.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The repository interface for accessing and managing Appointment entities.
 * It provides methods to perform CRUD operations and additional querying capabilities on the Appointment entity.
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}