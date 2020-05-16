package sef.proj;

public class CouldNotWriteTaskException extends RuntimeException {
    public CouldNotWriteTaskException() { super(String.format("cannot write in database"));}
}
