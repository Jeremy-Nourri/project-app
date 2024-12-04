package org.example.serverappproject.infrastructure.persistence.adapter;

import org.example.serverappproject.domain.model.PositionEnum;
import org.example.serverappproject.domain.model.User;
import org.example.serverappproject.domain.port.outbound.user.CreateUserPersistencePort;
import org.example.serverappproject.infrastructure.persistence.entity.PositionEntityEnum;
import org.example.serverappproject.infrastructure.persistence.entity.UserEntity;
import org.example.serverappproject.infrastructure.persistence.repository.UserJpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CreateUserPersistenceAdapter implements CreateUserPersistencePort {

    private final UserJpaRepository userJpaRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CreateUserPersistenceAdapter(UserJpaRepository userJpaRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userJpaRepository = userJpaRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = mapToEntity(user);
        UserEntity savedEntity = userJpaRepository.save(userEntity);
        return mapToDomain(savedEntity);
    }

    @Override
    public boolean userExistsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public String passwordEncoder(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    private UserEntity mapToEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                PositionEntityEnum.valueOf(user.getPositionEnum().name()),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    private User mapToDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                PositionEnum.valueOf(userEntity.getPosition().name()),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
        );
}
}
