package com.RestApiApp.journalApp.controller;

import com.RestApiApp.journalApp.entity.UserEntry;
import com.RestApiApp.journalApp.repository.UserRepo;
import com.RestApiApp.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserEntry user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();

        UserEntry userInDb = userService.findByUserName(currentUserName);

        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewEntry(userInDb);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepo.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
