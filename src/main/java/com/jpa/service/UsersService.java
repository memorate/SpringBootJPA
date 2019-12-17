package com.jpa.service;

import com.jpa.model.User;
import com.jpa.repository.UsersRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UsersService {

    @Resource
    private UsersRepository usersRepository;

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public User getByAge(int age) {
        return usersRepository.findByName(age);
    }

    public int updateName(String name) {
        return usersRepository.updateSpecific(name);
    }

    public User getByNameAndAge(String name, int age) {
        return usersRepository.findByNameAndAge(name, age);
    }

    public User getByName(String name) {
        return usersRepository.findByName(name);
    }

    public void deleteById(long id){
        usersRepository.deleteById(id);
    }

    public int deleteByName(String name){
        return usersRepository.deleteUserByName(name);
    }

    public User save(User user){
        return usersRepository.save(user);
    }

    public List<User> singleSort() {
        JpaSort sort = JpaSort.unsafe(Sort.Direction.ASC, "LENGTH(description)");
        return usersRepository.findAll(sort);
    }

    public List<User> multiSort() {
        Sort.Order idOrder = Sort.Order.asc("id");
        Sort.Order nameOrder = Sort.Order.desc("name");
        return usersRepository.findAll(Sort.by(idOrder, nameOrder));
    }

    public List<User> page(int pageNum, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC, "age");
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, sort);
        Page<User> userPage = usersRepository.findAll(pageRequest);
        return userPage.getContent();
    }


}
