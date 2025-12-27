package com.RestApiApp.journalApp.controller;

import com.RestApiApp.journalApp.entity.UserEntry;
import com.RestApiApp.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    public UserService userService;

    @GetMapping("/adminCheck")
    public String healthCheck() {
        return "ADMIN ADMIN";
    }

    @GetMapping("/allUsers")
    public ResponseEntity<?> getAllUsers() {
        List<UserEntry> all = userService.getAll();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createAdminUser")
        public void createUser(@RequestBody UserEntry userEntry){
            userService.saveAdmin(userEntry);
        }

}
