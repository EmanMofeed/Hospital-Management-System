package com.example.Assignment1.service;

import com.example.Assignment1.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto appointmentDto);

    List<AppointmentDto> getAllAppointments();

    AppointmentDto getAppointmentById(int id);

    void deleteAppointmentById(int id);

    AppointmentDto updateAppointment(AppointmentDto appointmentDto, int id);

}
