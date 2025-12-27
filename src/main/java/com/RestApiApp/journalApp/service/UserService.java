package com.RestApiApp.journalApp.service;

import com.RestApiApp.journalApp.entity.UserEntry;
import com.RestApiApp.journalApp.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean saveNewEntry(UserEntry userEntry){
        try {
            userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
            userEntry.setRole(Arrays.asList("USER"));
            userRepo.save(userEntry);
            return true;
        } catch (Exception e) {
//            logger.info("hehehehehehe");
//            logger.error("Error: ", userEntry.getUserName(), e);

            log.info("hehehehehehe");
            log.error("Error: ", userEntry.getUserName(), e);

            log.error("hahahahahaha");
            log.warn("hahahahahaha");
            log.info("hahahahahaha");
            log.debug("hahahahahaha");
            log.trace("hahahahahaha");

            return false;
        }

    }

    public void saveAdmin(UserEntry userEntry){
        userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
        userEntry.setRole(Arrays.asList("USER", "ADMIN"));
        userRepo.save(userEntry);
    }

    public void saveUser(UserEntry userEntry){
        userRepo.save(userEntry);
    }

    public List<UserEntry> getAll(){
        return userRepo.findAll();
    }

    public Optional<UserEntry> findById(ObjectId id){
        return userRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepo.deleteById(id);
    }

    public UserEntry findByUserName(String userName){
        return userRepo.findByUserName(userName);
    }

}
