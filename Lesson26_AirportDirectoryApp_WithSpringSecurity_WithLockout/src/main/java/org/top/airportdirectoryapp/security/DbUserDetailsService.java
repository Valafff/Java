package org.top.airportdirectoryapp.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.top.airportdirectoryapp.storage.UserDbEntity;
import org.top.airportdirectoryapp.storage.UserRepository;

import java.util.Optional;

// DbUserDetailsService - имплементация UserDetailsService работающая с БДы
@Service
public class DbUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public DbUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. найти пользователя в БД по логину
        Optional<UserDbEntity> user = userRepository.findByLogin(username);
        // 2. если пользователь не найден
        if (user.isEmpty()) {
            throw  new UsernameNotFoundException(username);
        }
        // 3. иначе собрать и вернуть UserDetails
        return new DbUserDetails(user.get());
    }
}
