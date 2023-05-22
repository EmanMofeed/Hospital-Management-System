package com.example.Assignment1.service.impl;

import com.example.Assignment1.dto.AppointmentDto;
import com.example.Assignment1.dto.DoctorDto;
import com.example.Assignment1.dto.PatientDto;
import com.example.Assignment1.entity.Appointment;
import com.example.Assignment1.entity.Doctor;
import com.example.Assignment1.entity.Patient;
import com.example.Assignment1.exception.ResourceNotFoundException;
import com.example.Assignment1.repository.AppointmentRepository;
import com.example.Assignment1.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {

        // convert DTO to entity
        Appointment appointment = mapToEntity(appointmentDto);
        Appointment newAppointment = appointmentRepository.save(appointment);

        // convert entity to DTO
        return mapToDTO(newAppointment);
    }

    @Override
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDto getAppointmentById(int id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
        return mapToDTO(appointment);
    }

    @Override
    public void deleteAppointmentById(int id) {
        // get Appointment by id from the database
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));
        appointmentRepository.delete(appointment);
    }


    // convert DTO to entity
    private Appointment mapToEntity(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();

        DoctorDto doctorDto = appointmentDto.getDoctor();

        if (doctorDto != null) {
            Doctor doctor = new Doctor();
            doctor.setDoctorId(doctorDto.getDoctorId());
            doctor.setName(doctorDto.getName());
            // Set other properties of Doctor as needed
            appointment.setDoctor(doctor);
        }

        PatientDto patientDto = appointmentDto.getPatient();

        if (patientDto != null) {
            Patient patient = new Patient();
            patient.setPatientId(patientDto.getPatientId());
            patient.setName(patientDto.getName());
            // Set other properties of Patient as needed

            appointment.setPatient(patient);
        }

        return appointment;
    }


    // convert Entity into DTO
    private AppointmentDto mapToDTO(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setId(appointment.getId());
        Doctor doctor = appointment.getDoctor();
        if (doctor != null) {
            appointmentDto.setDoctor(doctor.getDoctorId());
        }
        Patient patient = appointment.getPatient();
        if (patient != null) {
            appointmentDto.setPatient(patient.getPatientId());
        }
        return appointmentDto;
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto, int id) {
        // get appointment by id from the database
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", id));

        // Convert PatientDto to Patient
        Patient patient = mapToPatient(appointmentDto.getPatient());
        Doctor doctor = mapToDoctor(appointmentDto.getDoctor());

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        Appointment updatedAppointment = appointmentRepository.save(appointment);
        return mapToDTO(updatedAppointment);
    }

    private Patient mapToPatient(PatientDto patientDto) {

        Patient patient = new Patient();
        patient.setPatientId(patientDto.getPatientId());
        patient.setName(patientDto.getName());
        return patient;
    }
    private Doctor mapToDoctor(DoctorDto doctorDto) {

        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorDto.getDoctorId());
        doctor.setName(doctorDto.getName());
        return doctor;
    }
}
