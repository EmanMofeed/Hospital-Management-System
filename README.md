# Hospital-Management-System

This is an Hospital management system that allows users to create, update, and delete appointments for doctors and patients.

## Table of Contents

- [Controllers](#controllers)
- [DTOs](#dtos)
- [Entities](#entities)
- [Repositories](#repositories)
- [Services](#services)
- [PDF Table](#PDF)
- [UML](#UML)

-- Note: Added the postman collection to the repo 

## Controllers

### PatientController

- Endpoint: `/patients`
- Description: Manages patient-related operations.
- API Endpoints:
  - `POST /patients`: Create a new patient.
  - `GET /patients`: Get all patients.
  - `GET /patients/{id}`: Get a patient by ID.
  - `PUT /patients/{id}`: Update a patient by ID.
  - `DELETE /patients/{id}`: Delete a patient by ID.

### DoctorController

- Endpoint: `/doctors`
- Description: Manages doctor-related operations.
- API Endpoints:
  - `POST /doctors`: Create a new doctor.
  - `GET /doctors`: Get all doctors.
  - `GET /doctors/{id}`: Get a doctor by ID.
  - `PUT /doctors/{id}`: Update a doctor by ID.
  - `DELETE /doctors/{id}`: Delete a doctor by ID.

### AppointmentController

- Endpoint: `/appointments`
- Description: Manages appointment-related operations.
- API Endpoints:
  - `POST /appointments`: Create a new appointment.
  - `GET /appointments`: Get all appointments.
  - `GET /appointments/{id}`: Get an appointment by ID.
  - `DELETE /appointments/{id}`: Delete an appointment by ID.

### DoctorSpecialityController

- Endpoint: `/doctor-specialities`
- Description: Manages doctor speciality-related operations.
- API Endpoints:
  - `POST /doctor-specialities`: Create a new doctor speciality.
  - `GET /doctor-specialities`: Get all doctor specialities.
  - `GET /doctor-specialities/{id}`: Get a doctor speciality by ID.
  - `PUT /doctor-specialities/{id}`: Update a doctor speciality by ID.
  - `DELETE /doctor-specialities/{id}`: Delete a doctor speciality by ID.

## DTOs

- Description: Data transfer object for resources details.

## Entities

- Description: Entity class representing a resource.

## Repositories

- Description: Repository interface for accessing and managing resource entities.

## Services

###  e.g PatientService

- Description: Service interface for patient-related operations.
- Methods:
  - `createPatient(patientDto)`: Create a new patient.
  - `getAllPatients()`: Get all patients.
  - `getPatientById(id)`: Get a patient by ID.
  - `updatePatient(patientDto, id)`: Update a patient by ID.
  - `deletePatientById(id)`: Delete a patient by ID.

## PDF Table 
https://drive.google.com/file/d/1Z13KMgOw4InX4ILu8XH9c_fzHF_pph-7/view?usp=sharing


## UML

![Blank diagram - UML Class (1)](https://github.com/EmanMofeed/Hospital-Management-System/assets/86316644/d8bc3516-4020-4a93-aa4d-6e0c63b77848)
