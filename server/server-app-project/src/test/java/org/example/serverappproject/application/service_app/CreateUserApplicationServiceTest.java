package org.example.serverappproject.application.service_app;

import org.example.serverappproject.application.dto.user.UserRequestDto;
import org.example.serverappproject.application.dto.user.UserResponseDto;
import org.example.serverappproject.domain.model.PositionEnum;
import org.example.serverappproject.domain.model.User;
import org.example.serverappproject.domain.port.inbound.user.CreateUserUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CreateUserApplicationServiceTest {

    private CreateUserUseCase createUserUseCase;
    private CreateUserApplicationService createUserApplicationService;

    @BeforeEach
    public void setUp() {
        createUserUseCase = mock(CreateUserUseCase.class);
        createUserApplicationService = new CreateUserApplicationService(createUserUseCase);
    }

    @Test
    public void testCreateUser() {
        // Arrange
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setFirstName("John");
        userRequestDto.setLastName("Doe");
        userRequestDto.setEmail("john.doe@example.com");
        userRequestDto.setPassword("password123");
        userRequestDto.setPosition("DEVELOPER");

        User createdUser = new User("John", "Doe", "john.doe@example.com", "password123", PositionEnum.DEVELOPER);
        createdUser.setId(1234L);

        UserResponseDto expectedResponse = new UserResponseDto();
        expectedResponse.setId(1234L);
        expectedResponse.setFirstName("John");
        expectedResponse.setLastName("Doe");
        expectedResponse.setEmail("john.doe@example.com");
        expectedResponse.setPosition("DEVELOPER");

        when(createUserUseCase.createUser(anyString(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn(createdUser);

        // Act
        UserResponseDto actualResponse = createUserApplicationService.createUser(userRequestDto);

        // Assert
        assertEquals(expectedResponse.getId(), actualResponse.getId());
        assertEquals(expectedResponse.getFirstName(), actualResponse.getFirstName());
        assertEquals(expectedResponse.getLastName(), actualResponse.getLastName());
        assertEquals(expectedResponse.getEmail(), actualResponse.getEmail());
        assertEquals(expectedResponse.getPosition(), actualResponse.getPosition());

        verify(createUserUseCase, times(1))
                .createUser(anyString(), anyString(), anyString(), anyString(), anyString());
    }
}
