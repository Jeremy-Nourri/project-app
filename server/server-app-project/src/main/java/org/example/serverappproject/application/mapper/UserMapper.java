package org.example.serverappproject.application.mapper;

import org.example.serverappproject.application.dto.user.UserRequestDto;
import org.example.serverappproject.application.dto.user.UserResponseDto;
import org.example.serverappproject.domain.model.PositionEnum;
import org.example.serverappproject.domain.model.User;

public class UserMapper {

    public static User toDomain(UserRequestDto dto) {
        return new User(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPassword(),
                PositionEnum.valueOf(dto.getPosition())
        );
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPositionEnum().toString(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
