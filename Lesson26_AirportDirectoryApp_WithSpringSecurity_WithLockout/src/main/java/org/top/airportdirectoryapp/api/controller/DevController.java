package org.top.airportdirectoryapp.api.controller;

import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.top.airportdirectoryapp.storage.UserDbEntity;
import org.top.airportdirectoryapp.storage.UserRepository;

// DevController - контроллер только для целей разработки
@RestController
@RequestMapping("api/dev")
public class DevController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public DevController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    // регистрация пользователя в БД
    @PostMapping("register-db-user")
    public UserDbEntity registerDbUser(
        @RequestParam String login,
        @RequestParam String password,
        @RequestParam String role
    ) {
        UserDbEntity user = new UserDbEntity();
        user.setLogin(login);
        user.setRole(role);
        String passwordHash = passwordEncoder.encode(password);
        user.setPasswordHash(passwordHash);
        userRepository.save(user);
        return user;
    }
}
