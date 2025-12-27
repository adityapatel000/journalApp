package com.RestApiApp.journalApp.repository;

import com.RestApiApp.journalApp.entity.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepo extends MongoRepository<UserEntry, ObjectId> {

    UserEntry findByUserName(String username);

    @Transactional
    void deleteByUserName(String username);


}
