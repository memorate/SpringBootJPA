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
        return usersService.getAllUsers();
    }

    @RequestMapping("/age")
    public User getByAge() {
        return usersService.getByAge(18);
    }

    @RequestMapping("/name")
    public int updateName() {
        return usersService.updateName("黄十");
    }

    @RequestMapping("/nameAndAge")
    public User getByNameAndAge() {
        return usersService.getByNameAndAge("张三", 18);
    }

    @RequestMapping("/like")
    public User getByName() {
        return usersService.getByName("%a%");
    }

    @RequestMapping("delId")
    public void deleteById() {
        usersService.deleteById(1010);
    }

    @RequestMapping("delName")
    public void deleteByName() {
        usersService.deleteByName("anchor");
    }

    @RequestMapping("save")
    public User saveUser() {
        User user = new User();
        user.setName("anchor");
        user.setAge(17);
        user.setDescription("handsome");
        return usersService.save(user);
    }

    @RequestMapping("update")
    public User updateUser() {
        User user = new User();
        user.setId(6L);
        user.setName("anchor");
        user.setAge(27);
        user.setDescription("handsome");
        return usersService.save(user);
    }

    @RequestMapping("sort")
    public List<User> sort(){
        return usersService.singleSort();
    }

    @RequestMapping("page")
    public List<User> page(){
        return usersService.page(0,2);
    }
}
