package com.kalam.patientservice.service;

import com.kalam.patientservice.dto.PatientRequestDTO;
import com.kalam.patientservice.dto.PatientResponseDTO;
import com.kalam.patientservice.exception.EmailAlreadyExistsException;
import com.kalam.patientservice.exception.PatinetNotFoundException;
import com.kalam.patientservice.mapper.PatientMapper;
import com.kalam.patientservice.model.Patient;
import com.kalam.patientservice.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service

public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public List<PatientResponseDTO>getPatients(){
        //get patients
        List<Patient> patients = patientRepository.findAll();

        //convert the patients and convert to responseDTO
        return patients.stream().map(PatientMapper::toDTO).toList();
    }
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail()))
            throw new EmailAlreadyExistsException("This email is already exists" + patientRequestDTO.getEmail());
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO)); //to save this data tupe should be "Patient"
        return PatientMapper.toDTO(newPatient);
    }

    public PatientResponseDTO updatePatient(UUID uuid,  PatientRequestDTO patientRequestDTO){
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();

        Patient patient = patientRepository.findById(uuid).orElseThrow(
                ()-> new PatinetNotFoundException("Patient not found with ID:"+ uuid));

        if(patientRepository.existsByEmail(patientRequestDTO.getEmail()))
            throw new EmailAlreadyExistsException("This email is already exists" + patientRequestDTO.getEmail());

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        Patient updatedPatient = patientRepository.save(patient);

        return PatientMapper.toDTO(updatedPatient);


    }
}

