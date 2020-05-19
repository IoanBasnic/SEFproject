package test;

import org.junit.Assert;
import org.junit.Test;
import sef.proj.User;
import sef.proj.UserService;

class UserServiceTest {

    @Test
    void addUserTest() {
        UserService test = new UserService();

        for (User name : test.getUsers()){
            Assert.assertEquals(name.getUserName().matches("^[\\\\p{L} .'-]+$"),name.getUserName());
        }
    }
}