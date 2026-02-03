package com.kalam.patientservice.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//take i/p from the user -- string values
//can use to validate the i/p values
@Setter @Getter
public class PatientRequestDTO {
    //fields
    @NotBlank
    @Size(max = 100, message = "Name cant exceed 100 characters")
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String dateOfBirth;

    @NotBlank
    private String registeredDate;

    @NotBlank
    private String address;

}
