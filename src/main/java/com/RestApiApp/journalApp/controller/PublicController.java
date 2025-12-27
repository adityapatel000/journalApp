package com.RestApiApp.journalApp.controller;

import com.RestApiApp.journalApp.entity.UserEntry;
import com.RestApiApp.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    public UserService userService;

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "OK";
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody UserEntry userEntry){
        userService.saveNewEntry(userEntry);
    }

}

