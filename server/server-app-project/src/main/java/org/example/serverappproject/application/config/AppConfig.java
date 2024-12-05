package org.example.serverappproject.application.config;

import org.example.serverappproject.domain.port.inbound.user.CreateUserUseCase;
import org.example.serverappproject.domain.service.user.CreateUserService;
import org.example.serverappproject.domain.port.outbound.user.CreateUserPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public CreateUserUseCase createUserUseCase(CreateUserPersistencePort createUserPersistencePort) {
        return new CreateUserService(createUserPersistencePort);
    }
}
