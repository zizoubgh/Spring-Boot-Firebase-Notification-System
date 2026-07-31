package com.springbootTS.springbootTS.model;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private Integer age;

}