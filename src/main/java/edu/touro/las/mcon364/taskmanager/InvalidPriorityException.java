package edu.touro.las.mcon364.taskmanager;

public class InvalidPriorityException extends RuntimeException {
    public InvalidPriorityException(String message) {
        super(message);
    }
    public InvalidPriorityException() {}
}
