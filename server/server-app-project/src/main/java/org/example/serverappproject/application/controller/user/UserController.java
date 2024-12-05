package org.example.serverappproject.application.controller.user;

import org.example.serverappproject.application.service_app.user.CreateUserApplicationService;
import org.example.serverappproject.application.dto.user.UserRequestDto;
import org.example.serverappproject.application.dto.user.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final CreateUserApplicationService createUserApplicationService;

    @Autowired
    public UserController(CreateUserApplicationService createUserApplicationService) {
        this.createUserApplicationService = createUserApplicationService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        try {
            UserResponseDto userResponseDto = createUserApplicationService.createUser(userRequestDto);
            return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

