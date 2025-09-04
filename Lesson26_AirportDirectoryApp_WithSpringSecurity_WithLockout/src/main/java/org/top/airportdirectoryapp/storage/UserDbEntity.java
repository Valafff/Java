package org.top.airportdirectoryapp.storage;


import jakarta.persistence.*;

// UserDbEntity - БД-сущность пользователя
@Entity
@Table(name="user_t")
public class UserDbEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="login_t", nullable = false)
    private String login;

    @Column(name="password_hash_t", nullable = false)
    private String passwordHash;

    @Column(name="role_t", nullable = false)
    private String role;

    @Column(name="failed_attempts_t", nullable = false)
    private Integer failedAttempts = 0;

    @Column(name="locked_until_t")
    private java.time.LocalDateTime lockedUntil;

    public UserDbEntity() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(Integer failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public java.time.LocalDateTime getLockedUntil() {
        return lockedUntil;
    }

    public void setLockedUntil(java.time.LocalDateTime lockedUntil) {
        this.lockedUntil = lockedUntil;
    }
}
