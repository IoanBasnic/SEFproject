package sef.proj.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.Test;
import sef.proj.model.User;
import sef.proj.services.UserService;

class UserServiceTest {

    @Test
    void addUserTest() {
        UserService test = new UserService();

        for (User name : test.getUsers()){
            Assert.assertEquals(name.getUserName().matches("^[\\\\p{L} .'-]+$"),name.getUserName());
        }
    }
}