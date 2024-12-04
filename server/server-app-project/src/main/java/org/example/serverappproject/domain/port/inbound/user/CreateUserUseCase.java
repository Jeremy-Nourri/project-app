package org.example.serverappproject.domain.port.inbound.user;

import org.example.serverappproject.domain.model.User;

public interface CreateUserUseCase {
    User createUser(String firstName, String lastName, String email, String password, String positionEnum);
}
