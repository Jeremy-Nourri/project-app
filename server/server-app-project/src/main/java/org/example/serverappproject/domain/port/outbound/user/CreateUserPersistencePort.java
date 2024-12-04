package org.example.serverappproject.domain.port.outbound.user;

import org.example.serverappproject.domain.model.User;

public interface CreateUserPersistencePort {
    User save(User user);
    boolean userExistsByEmail(String email);
    String passwordEncoder(String password);
}

