package com.example.Assignment1.repository;

import com.example.Assignment1.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * The repository interface for accessing and managing Doctor entities.
 * It provides methods to perform CRUD operations and additional querying capabilities on the Doctor entity.
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
