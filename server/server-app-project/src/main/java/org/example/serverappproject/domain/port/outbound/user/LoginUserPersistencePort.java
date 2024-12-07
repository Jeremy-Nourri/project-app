package org.example.serverappproject.domain.port.outbound.user;

import org.example.serverappproject.domain.model.User;

import java.util.Optional;

public interface LoginUserPersistencePort {
    Optional<User> findByEmail(String email);
}
