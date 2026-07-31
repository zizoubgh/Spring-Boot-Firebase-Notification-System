package com.springbootTS.springbootTS.controller;


import com.springbootTS.springbootTS.dto.UserDTO;
import com.springbootTS.springbootTS.model.User;
import com.springbootTS.springbootTS.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public List<User> getAll(){

        return service.findAll();

    }

    @GetMapping("/{id}")
    public User getById(@PathVariable String id){

        return service.findById(id);

    }

    @PostMapping
    public User save(@Valid @RequestBody UserDTO dto){

        System.out.println("FIRST NAME = " + dto.getFirstName());
        System.out.println("LAST NAME = " + dto.getLastName());
        System.out.println("EMAIL = [" + dto.getEmail() + "]");
        System.out.println("AGE = " + dto.getAge());



        return service.save(dto);

    }

    @PutMapping("/{id}")
    public User update(
            @PathVariable String id,
            @Valid @RequestBody UserDTO dto){

        return service.update(id,dto);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){

        service.delete(id);

    }

}