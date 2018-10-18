package com.cletus.ejercicio.service.impl;

import com.cletus.ejercicio.converter.UserConverter;
import com.cletus.ejercicio.model.dto.UserDto;
import com.cletus.ejercicio.model.entity.User;
import com.cletus.ejercicio.repository.UserRepository;
import com.cletus.ejercicio.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired private UserConverter userConverter;
    @Autowired private UserRepository userRepository;

    @Override
    public void save(UserDto userDto) {
        User u = userConverter.toEntity(userDto);
        userRepository.save(u);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        Optional<User> opt = userRepository.findById(id);
        if(opt.isPresent()){

        }
    }
}
