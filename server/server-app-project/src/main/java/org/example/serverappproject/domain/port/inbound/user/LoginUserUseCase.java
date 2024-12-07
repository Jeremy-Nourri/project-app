package org.example.serverappproject.domain.port.inbound.user;

public interface LoginUserUseCase {
    String loginUser(String email, String password);
}
