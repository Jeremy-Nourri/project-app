package org.example.serverappproject.infrastructure.persistence.adapter;

import org.example.serverappproject.infrastructure.persistence.repository.UserJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUserPersistanceAdapterTest {

    private CreateUserPersistenceAdapter createUserPersistenceAdapter;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserJpaRepository userJpaRepository;

    @BeforeEach
    public void setUp() {
        bCryptPasswordEncoder = Mockito.mock(BCryptPasswordEncoder.class);
        userJpaRepository = Mockito.mock(UserJpaRepository.class);
        createUserPersistenceAdapter = new CreateUserPersistenceAdapter(userJpaRepository, bCryptPasswordEncoder);
    }

    @Test
    public void testPasswordEncoder() {
        // Given
        String rawPassword = "password";
        String encodedPassword = "encodedPassword";

        Mockito.when(bCryptPasswordEncoder.encode(rawPassword)).thenReturn(encodedPassword);

        // When
        String result = createUserPersistenceAdapter.passwordEncoder(rawPassword);

        // Then
        assertEquals(encodedPassword, result);
    }

    @Test
    public void testUserExistsByEmail() {
        // Given
        String email = "test@example.com";
        Mockito.when(userJpaRepository.existsByEmail(email)).thenReturn(true);

        // When
        boolean result = createUserPersistenceAdapter.userExistsByEmail(email);

        // Then
        assertTrue(result);
    }

}
