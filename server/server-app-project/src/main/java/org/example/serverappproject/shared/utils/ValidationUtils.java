package org.example.serverappproject.shared.utils;

import org.example.serverappproject.domain.exception.user.InvalidEmailFormatException;

public class ValidationUtils {

    private ValidationUtils() {
    }

    public static void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new InvalidEmailFormatException("Email cannot be null or empty.");
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!email.matches(emailRegex)) {
            throw new InvalidEmailFormatException("Invalid email format: " + email);
        }
    }
}
