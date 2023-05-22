package com.example.Assignment1.contorller;

import com.example.Assignment1.dto.DoctorSpecialtyDto;
import com.example.Assignment1.service.DoctorSpecialtyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor-specialties")
public class DoctorSpecialtyController {

    private DoctorSpecialtyService doctorSpecialtyService;

    public DoctorSpecialtyController(DoctorSpecialtyService doctorSpecialtyService) {
        this.doctorSpecialtyService = doctorSpecialtyService;
    }

    @PostMapping
    public ResponseEntity<DoctorSpecialtyDto> createDoctorSpecialty(@RequestBody DoctorSpecialtyDto doctorSpecialtyDto) {
        DoctorSpecialtyDto createdDoctorSpecialty = doctorSpecialtyService.createDoctorSpecialty(doctorSpecialtyDto);
        return new ResponseEntity<>(createdDoctorSpecialty, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DoctorSpecialtyDto>> getAllDoctorSpecialties() {
        List<DoctorSpecialtyDto> doctorSpecialties = doctorSpecialtyService.getAllDoctorSpecialties();
        return new ResponseEntity<>(doctorSpecialties, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorSpecialtyDto> getDoctorSpecialtyById(@PathVariable int id) {
        DoctorSpecialtyDto doctorSpecialty = doctorSpecialtyService.getDoctorSpecialtyById(id);
        return new ResponseEntity<>(doctorSpecialty, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorSpecialtyDto> updateDoctorSpecialty(@RequestBody DoctorSpecialtyDto doctorSpecialtyDto, @PathVariable int id) {
        DoctorSpecialtyDto updatedDoctorSpecialty = doctorSpecialtyService.updateDoctorSpecialty(doctorSpecialtyDto, id);
        return new ResponseEntity<>(updatedDoctorSpecialty, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctorSpecialtyById(@PathVariable int id) {
        doctorSpecialtyService.deleteDoctorSpecialtyById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

