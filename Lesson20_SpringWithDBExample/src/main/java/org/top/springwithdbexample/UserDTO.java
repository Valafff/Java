package org.top.springwithdbexample;

import java.time.LocalDateTime;

public class UserDTO
{
    public UserDTO() {
    }

    public UserDTO(Long id, String username, LocalDateTime registeredAt, Integer discountPoints, WalletDTO wallet) {
        this.id = id;
        this.username = username;
        this.registeredAt = registeredAt;
        this.discountPoints = discountPoints;
        this.wallet = wallet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Integer getDiscountPoints() {
        return discountPoints;
    }

    public void setDiscountPoints(Integer discountPoints) {
        this.discountPoints = discountPoints;
    }

    public WalletDTO getWallet() {
        return wallet;
    }

    public void setWallet(WalletDTO wallet) {
        this.wallet = wallet;
    }

    private Long id;
    private String username;
    private LocalDateTime registeredAt;
    private Integer discountPoints;
    private WalletDTO wallet;
}
