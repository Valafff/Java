package org.top.airportdirectoryapp.security;

import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.top.airportdirectoryapp.storage.UserDbEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

// DbUserDetails - имплементация UserDetails работающая с БД
// базируется на агрегации БД-сущности пользователя
public class DbUserDetails implements UserDetails {

    private UserDbEntity user;   // сущность пользователя из БД

    public DbUserDetails() {}

    public DbUserDetails(UserDbEntity user) {
        this.user = user;
    }

    public UserDbEntity getUser() {
        return user;
    }

    public void setUser(UserDbEntity user) {
        this.user = user;
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }


    @Override
    public String getPassword() {
        return user.getPasswordHash();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Проверяем, не заблокирован ли аккаунт
        if (user.getLockedUntil() == null) {
            return true;
        }
        return java.time.LocalDateTime.now().isAfter(user.getLockedUntil());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
