package org.top.springwithdbexample;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="user_t")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="username_f", nullable = false, unique = true)
    private String username;

    @Column(name="registered_at_f", nullable = false)
    private Date registeredAt;

    @Column(name="discount_points_f")
    private Integer discountPoints;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    private  UserWallet wallet;

    public void setWallet(UserWallet wallet) {
        this.wallet = wallet;
    }

    public UserWallet getWallet() {
        return wallet;
    }

    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Integer getDiscountPoints() {
        return discountPoints;
    }

    public void setDiscountPoints(Integer discountPoints) {
        this.discountPoints = discountPoints;
    }
}
