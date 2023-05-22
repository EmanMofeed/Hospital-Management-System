package com.example.Assignment1.contorller;

import com.example.Assignment1.dto.DoctorDto;
import com.example.Assignment1.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    /**
     * Endpoint for creating a new doctor.
     * Accepts a POST request with the doctor data in the request body.
     * Returns the created doctor with the HTTP status code 201 (Created).
     */
    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
        DoctorDto createdDoctor = doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }

    /**
     * Endpoint for retrieving all doctors.
     * Accepts a GET request and returns a list of all doctors with the HTTP status code 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        List<DoctorDto> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving a doctor by ID.
     * Accepts a GET request with the doctor ID as a path variable.
     * Returns the doctor with the specified ID with the HTTP status code 200 (OK).
     */
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable int id) {
        DoctorDto doctor = doctorService.getDoctorById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    /**
     * Endpoint for updating a doctor.
     * Accepts a PUT request with the updated doctor data in the request body
     * and the doctor ID as a path variable.
     * Returns the updated doctor with the HTTP status code 200 (OK).
     */
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto doctorDto, @PathVariable int id) {
        DoctorDto updatedDoctor = doctorService.updateDoctor(doctorDto, id);
        return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
    }

    /**
     * Endpoint for deleting a doctor by ID.
     * Accepts a DELETE request with the doctor ID as a path variable.
     * Returns no content with the HTTP status code 204 (No Content).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctorById(@PathVariable int id) {
        doctorService.deleteDoctorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
