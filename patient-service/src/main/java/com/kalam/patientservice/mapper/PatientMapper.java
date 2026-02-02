package com.kalam.patientservice.mapper;

import com.kalam.patientservice.dto.PatientResponseDTO;
import com.kalam.patientservice.model.Patient;

public class PatientMapper {


    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientResponseDTO;

    }

}
