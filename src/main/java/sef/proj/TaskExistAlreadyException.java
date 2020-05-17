package sef.proj;

public class TaskExistAlreadyException extends Exception {

    private String task;

    public TaskExistAlreadyException(String task) {
        super(String.format("The task %s already exist!",task));
        this.task = task;
    }

    public String getTask() {
        return task;
    }
}
