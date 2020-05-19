package sef.proj.services;

import org.junit.Assert;
import org.junit.Test;

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

}