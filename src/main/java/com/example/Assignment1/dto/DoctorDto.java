package com.example.Assignment1.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

//Data validation
@Data
public class DoctorDto {
    private int doctorId;

    @NotNull
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @Size(min = 3, max = 100)
    private String specialty;

    @NotNull
    @Size(min = 3, max = 100)
    private String schedule;
}
