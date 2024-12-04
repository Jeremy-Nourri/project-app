package org.example.serverappproject.domain.exception.user;

public class InvalidPositionException extends InvalidUserInputException {
    public InvalidPositionException() {
        super("Invalid position.");
    }
}