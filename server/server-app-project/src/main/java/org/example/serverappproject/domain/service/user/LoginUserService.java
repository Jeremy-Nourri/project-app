package org.example.serverappproject.domain.service.user;


import org.example.serverappproject.domain.exception.user.InvalidPasswordException;
import org.example.serverappproject.domain.exception.user.UserNotFoundException;
import org.example.serverappproject.domain.model.User;
import org.example.serverappproject.domain.port.inbound.user.LoginUserUseCase;
import org.example.serverappproject.domain.port.outbound.user.LoginUserPersistencePort;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.example.serverappproject.shared.utils.ValidationUtils.validateEmail;

public class LoginUserService implements LoginUserUseCase {

    private final LoginUserPersistencePort loginUserPersistencePort;
    private final PasswordEncoder passwordEncoder;

    public LoginUserService(LoginUserPersistencePort loginUserPersistencePort, PasswordEncoder passwordEncoder) {
        this.loginUserPersistencePort = loginUserPersistencePort;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String loginUser(String email, String password) {
        validateEmail(email);

        Optional<User> userOptional = loginUserPersistencePort.findByEmail(email);
        User user = userOptional.orElseThrow(() -> new UserNotFoundException("User with email '" + email + "' not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidPasswordException("Invalid password.");
        }

        return

    }


}
