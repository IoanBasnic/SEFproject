package sef.proj.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.Test;
import sef.proj.model.User;
import sef.proj.services.UserService;

class UserServiceTest {

    @Test
    void nameUserTest() {
        UserService test = new UserService();

        for (User name : test.getUsers()){
            Assert.assertEquals(name.getUserName().matches("^[\\\\p{L} .'-]+$"),name.getUserName());
        }
    }

    @Test
    void tagTest() {
        UserService test = new UserService();

        for (User tag : test.getUsers()) {
            Assert.assertEquals(tag.getUserName().matches("(([01]?[0-9]):([0-5][0-9]) ([AaPp][Mm]))"),tag.getTag());
        }
    }
}