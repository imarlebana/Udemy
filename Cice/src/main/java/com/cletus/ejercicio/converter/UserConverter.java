package com.cletus.ejercicio.converter;


import com.cletus.ejercicio.model.dto.UserDto;
import com.cletus.ejercicio.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User toEntity(UserDto userDto){
        User u = new User();
        u.setName(userDto.getName());
        u.setSurname(userDto.getSurname());
        return u;
    }
}
