package org.top.springwithdbexample;

import jakarta.persistence.*;

@Entity
@Table(name="user_wallet_t")
public class UserWallet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="walletname_f", nullable = false, unique = true)
    private String walletname;

    @Column(name="walletpass_f", nullable = false, unique = false)
    private String walletpass;

    @Column(name="walletcount_f", nullable = false, unique = false)
    private String walletcount;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWalletname(String walletname) {
        this.walletname = walletname;
    }

    public void setWalletpass(String walletpass) {
        this.walletpass = walletpass;
    }

    public void setWalletcount(String walletcount) {
        this.walletcount = walletcount;
    }

    public UserWallet() {}

    public Integer getId() {
        return id;
    }

    public String getWalletname() {
        return walletname;
    }

    public String getWalletpass() {
        return walletpass;
    }

    public String getWalletcount() {
        return walletcount;
    }
}
