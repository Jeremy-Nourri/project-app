package org.example.serverappproject.domain.exception.user;

public class InvalidEmailFormatException extends InvalidUserInputException {
    public InvalidEmailFormatException(String message) {
        super(message);
    }
}
