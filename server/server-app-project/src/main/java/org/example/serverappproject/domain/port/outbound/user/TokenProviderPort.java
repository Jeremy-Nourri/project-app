package org.example.serverappproject.domain.port.outbound.user;

public interface TokenProviderPort {
    String generateToken(String username);
}
