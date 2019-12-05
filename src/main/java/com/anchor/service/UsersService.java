package com.anchor.service;

import com.anchor.model.Users;
import com.anchor.repository.UsersRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UsersService {

    @Resource
    private UsersRepository usersRepository;

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }
}
