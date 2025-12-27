package com.RestApiApp.journalApp.service;

import com.RestApiApp.journalApp.entity.UserEntry;
import com.RestApiApp.journalApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetaisServiceImp implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntry byUserName = userRepo.findByUserName(username);
        if(byUserName != null){
            return User.builder()
                    .username(byUserName.getUserName())
                    .password(byUserName.getPassword())
                    .roles(byUserName.getRole().toArray(new String[0]))
                    .build();
        }
        throw new UsernameNotFoundException("use not found with username: " + username);
    }
}


















