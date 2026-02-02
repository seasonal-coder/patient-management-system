package com.kalam.patientservice.service;

import com.kalam.patientservice.dto.PatientResponseDTO;
import com.kalam.patientservice.mapper.PatientMapper;
import com.kalam.patientservice.model.Patient;
import com.kalam.patientservice.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public List<PatientResponseDTO>getPatients(){
        //get patients
        List<Patient> patients = patientRepository.findAll();

        //convert the patients and convert to responseDTOm
        return patients.stream().map(PatientMapper::toDTO).toList();
    }
}
