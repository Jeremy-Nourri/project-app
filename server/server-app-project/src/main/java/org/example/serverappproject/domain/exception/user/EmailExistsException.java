package org.example.serverappproject.domain.exception.user;

public class EmailExistsException extends RuntimeException{
    public EmailExistsException() {
        super("Email already exists");
    }
}
