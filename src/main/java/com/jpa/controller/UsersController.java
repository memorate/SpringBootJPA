package com.jpa.controller;

import com.jpa.model.User;
import com.jpa.service.UsersService;
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
    public List<User> getAllUsers() {
        return usersService.getAllByDefault();
    }

    //类似调用UsersService中方法即可
    //...
}
