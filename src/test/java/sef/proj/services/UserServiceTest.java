package sef.proj.services;

import org.junit.Assert;
import org.junit.Test;
import sef.proj.exceptions.UsernameAlreadyExistException;
import  sef.proj.model.User;
import  sef.proj.services.UserService;
import  sef.proj.services.FileSystemService;
import  sef.proj.exceptions.*;
import static org.junit.Assert.*;

public class UserServiceTest {


    @Test
    public void testName() {

        String s  = "Adrian Achim";
        Assert.assertTrue(s.matches("^[A-Za-z]+.[A-Za-z]+$"));
    }

    @Test
    public void testTag() {

        String s = "G37R3K7N008";
        Assert.assertTrue(s.matches("[A-Za-z0-9]+"));
    }

    @Test
    public void testCheckUser (){
        UserService tuser = new UserService();
        try {
            tuser.addUser("vasile", "dadasd", "somename@somedomain", "G37R3K7N008", "0712345678", "Manager");
        }
        catch (UsernameAlreadyExistException e){

        }

        Assert.assertEquals("vasile",tuser.CheckUser("vasile","dadasd"));
    }




}