package sef.proj.services;

import org.junit.Assert;
import org.junit.Test;
import sef.proj.exceptions.TaskExistAlreadyException;
import sef.proj.exceptions.UsernameAlreadyExistException;
import sef.proj.model.Task;
import sef.proj.services.TaskService;

import static org.junit.Assert.*;

public class TaskServiceTest {

    @Test
    public void timeFormatTest () {

        String s="4:55 pm";
        Assert.assertTrue(s.matches("((1[0-2]|0?[1-9]):([0-5][0-9]) ([AaPp][Mm]))"));
    }




}