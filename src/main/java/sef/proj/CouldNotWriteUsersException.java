package sef.proj;

public class CouldNotWriteUsersException extends RuntimeException{
    public CouldNotWriteUsersException() {
        super(String.format("I can't write into the data base!"));
    }
}
