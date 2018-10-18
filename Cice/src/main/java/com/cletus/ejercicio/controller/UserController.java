package com.cletus.ejercicio.controller;

import com.cletus.ejercicio.model.dto.Response;
import com.cletus.ejercicio.model.dto.UserDto;
import com.cletus.ejercicio.model.entity.User;
import com.cletus.ejercicio.service.IResponseService;
import com.cletus.ejercicio.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired private IResponseService responseService;
    @Autowired private IUserService userService;

    @PostMapping("/user")
    public Response create(@Valid @RequestBody UserDto userDto, Errors error) {
        if (error.hasErrors()){
            return responseService.response(422,"Params error.");
        }
        userService.save(userDto);
        return responseService.response(200);
    }

    @GetMapping("/user")
    public Response get() {

        {
            List<User> users = userService.getAll();
            return responseService.data(users);
        }




        return responseService.response(200);
    }

}
