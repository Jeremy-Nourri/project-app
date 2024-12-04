package org.example.serverappproject.application.service_app;

import org.example.serverappproject.application.dto.user.UserRequestDto;
import org.example.serverappproject.application.dto.user.UserResponseDto;
import org.example.serverappproject.application.mapper.UserMapper;
import org.example.serverappproject.domain.model.User;
import org.example.serverappproject.domain.port.inbound.user.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserApplicationService {

    private final CreateUserUseCase createUserUseCase;

    @Autowired
    public CreateUserApplicationService(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = UserMapper.toDomain(userRequestDto);

        User createdUser = createUserUseCase.createUser(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getPositionEnum().name()
        );

        return UserMapper.toDto(createdUser);
    }
}
