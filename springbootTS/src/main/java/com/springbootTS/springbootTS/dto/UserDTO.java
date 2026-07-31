package com.springbootTS.springbootTS.dto;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class UserDTO {

    @NotBlank(message = "First name required")
    private String firstName;

    @NotBlank(message = "Last name required")
    private String lastName;

    @Email
    private String email;

    @Min(1)
    @Max(120)
    private Integer age;

}