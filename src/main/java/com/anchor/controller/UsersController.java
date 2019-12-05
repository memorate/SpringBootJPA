package com.anchor.controller;

import com.anchor.model.Users;
import com.anchor.service.UsersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Resource
    private UsersService usersService;

    @RequestMapping("/all")
    public List<Users> getAllUsers() {
        List<Users> users = usersService.getUsers();
        return users;
    }
}
