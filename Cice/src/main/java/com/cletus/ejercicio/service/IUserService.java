package com.cletus.ejercicio.service;

import com.cletus.ejercicio.model.dto.UserDto;
import com.cletus.ejercicio.model.entity.User;

import java.util.List;

public interface IUserService {

    void save(UserDto userDto);

    List<User> getAll();

    User get(Long id);
}
