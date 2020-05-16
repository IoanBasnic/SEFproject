package sef.proj;

public class TaskExistAlreadyException extends Exception {

    private String task;

    public TaskExistAlreadyException(String task) {
        super(String.format("An account with the username %s already exist!",task));
        this.task = task;
    }

    public String getTask() {
        return task;
    }
}
