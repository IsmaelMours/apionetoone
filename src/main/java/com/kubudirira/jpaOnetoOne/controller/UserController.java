package com.kubudirira.jpaOnetoOne.controller;


import com.kubudirira.jpaOnetoOne.model.Passport;
import com.kubudirira.jpaOnetoOne.model.User;
import com.kubudirira.jpaOnetoOne.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/user")
@Slf4j
public class UserController {


    private final UserService userService;


    @GetMapping("/all")
    public List<User> findAllUsers(){
        return userService.findAll();
    }
    @PostMapping("/save")
    public void save(@RequestBody User user){
        userService.save(user);
    }
    @PostMapping("/assignPassport/{user_id}")
    public void assignPassport(@RequestBody Passport passport, @PathVariable int user_id){
        User user = userService.findById(user_id).get();
        user.setPassport(passport);
        userService.save(user);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        userService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        return userService.update(id, user);
    }



}
