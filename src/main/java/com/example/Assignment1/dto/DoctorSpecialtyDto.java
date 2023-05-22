package com.example.Assignment1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DoctorSpecialtyDto {
    private int id;
    private DoctorDto doctor;
    private SpecialtyDto specialty;
}
