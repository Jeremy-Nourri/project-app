package org.example.serverappproject.domain.service;

import org.example.serverappproject.domain.exception.user.EmailExistsException;
import org.example.serverappproject.domain.exception.user.InvalidEmailFormatException;
import org.example.serverappproject.domain.exception.user.InvalidPositionException;
import org.example.serverappproject.domain.exception.user.InvalidUserInputException;
import org.example.serverappproject.domain.model.PositionEnum;
import org.example.serverappproject.domain.model.User;
import org.example.serverappproject.domain.port.inbound.user.CreateUserUseCase;
import org.example.serverappproject.domain.port.outbound.user.CreateUserPersistencePort;

public class CreateUserService implements CreateUserUseCase {

    private final CreateUserPersistencePort createUserPersistencePort;

    public CreateUserService(CreateUserPersistencePort createUserPersistencePort) {
        this.createUserPersistencePort = createUserPersistencePort;
    }

    @Override
    public User createUser(String firstName, String lastName, String email, String password, String positionEnum) {
        validateInputs(firstName, lastName, email, password, positionEnum);

        if(createUserPersistencePort.userExistsByEmail(email)){
            throw new EmailExistsException();
        }

        User user = new User(
                firstName,
                lastName,
                email,
                password,
                PositionEnum.valueOf(positionEnum)
        );
        return createUserPersistencePort.save(user);
    }

    private void validateInputs(String firstName, String lastName, String email, String password, String positionEnum) {
        if (firstName == null || firstName.isEmpty()) {
            throw new InvalidUserInputException("First name cannot be empty.");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new InvalidUserInputException("Last name cannot be empty.");
        }
        if (email == null || !email.contains("@")) {
            throw new InvalidEmailFormatException();
        }
        if (password == null || password.length() < 6) {
            throw new InvalidUserInputException("Password must be at least 6 characters.");
        }
        try {
            PositionEnum.valueOf(positionEnum);
        } catch (IllegalArgumentException e) {
            throw new InvalidPositionException();
        }
    }
}
