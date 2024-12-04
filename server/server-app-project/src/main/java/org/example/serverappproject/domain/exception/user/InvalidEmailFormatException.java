package org.example.serverappproject.domain.exception.user;

public class InvalidEmailFormatException extends InvalidUserInputException {
    public InvalidEmailFormatException() {
        super("Invalid email format.");
    }
}
