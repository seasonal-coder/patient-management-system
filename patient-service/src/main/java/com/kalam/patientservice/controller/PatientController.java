package com.kalam.patientservice.controller;


import com.kalam.patientservice.dto.PatientRequestDTO;
import com.kalam.patientservice.dto.PatientResponseDTO;
import com.kalam.patientservice.service.PatientService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")

public class PatientController {

    //fields
    PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    //methods
    //getallpatients()
    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }
    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO){
        PatientResponseDTO patientResponseDTO = patientService.createPatient(patientRequestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);
    }
}
