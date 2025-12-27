//package com.RestApiApp.journalApp.service;
//
//import com.RestApiApp.journalApp.entity.UserEntry;
//import com.RestApiApp.journalApp.repository.UserRepo;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class UserServiceTest {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Test
//    public void test1(){
//        assertEquals(4, 2+2);
//    }
//
//    @Test
//    public void testFindUSerName(){
//        assertNotNull(userRepo.findByUserName("one"));
//    }
//
//    @Disabled
//    @Test
//    public void testFindUSerNameInDataBase(){
//        UserEntry one = userRepo.findByUserName("one");
//        assertTrue(one.getJournalEntries().isEmpty());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {
//            "adi",
//            "Last",
//            "one",
//    })
//    public void test_FindUerNameInDataBase(String name){
//        assertNotNull(userRepo.findByUserName(name));
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2",
//            "2,10,12",
//            "3,3,6",
//    })
//    public void test(int a, int b, int expected){
//        assertEquals(expected, a + b);
//    }
//
//}
