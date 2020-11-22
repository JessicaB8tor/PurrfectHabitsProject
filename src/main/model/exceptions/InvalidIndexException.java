package model.exceptions;

public class InvalidIndexException extends Exception {
    public InvalidIndexException() {
        super("The index is not within the bounds of the journal");
    }
}
