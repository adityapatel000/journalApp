//package com.RestApiApp.journalApp.service;
//
//import com.RestApiApp.journalApp.entity.UserEntry;
//import com.RestApiApp.journalApp.repository.UserRepo;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.stubbing.OngoingStubbing;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UserDetailServiceTest {
//
//    @Mock
//    private UserRepo userRepo;
//
//    @InjectMocks
//    private UserDetaisServiceImp userDetailsServiceImp;
//
//    @Test
//    void loadUserByUserNameTest() {
//        UserEntry userEntry = new UserEntry();
//        userEntry.setUserName("adi");
//        userEntry.setPassword("asd");
//
//        when(userRepo.findByUserName(anyString()))
//                .thenReturn(userEntry);
//
//        UserDetails userDetails =
//                userDetailsServiceImp.loadUserByUsername("adi");
//
//        Assertions.assertNotNull(userDetails);
//        Assertions.assertEquals("adi", userDetails.getUsername());
//    }
//}
//
