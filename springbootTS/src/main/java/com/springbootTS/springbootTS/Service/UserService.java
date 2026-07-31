package com.springbootTS.springbootTS.Service;

import com.springbootTS.springbootTS.dto.UserDTO;
import com.springbootTS.springbootTS.model.User;

import java.util.List;

public interface UserService {

    User save(UserDTO dto);

    List<User> findAll();

    User findById(String id);

    User update(String id,UserDTO dto);

    void delete(String id);

}