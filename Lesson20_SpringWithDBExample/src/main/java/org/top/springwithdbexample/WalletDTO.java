package org.top.springwithdbexample;

public class WalletDTO
{
    public WalletDTO(Long id, String walletname, String walletpass, String walletcount) {
        this.id = id;
        this.walletname = walletname;
        this.walletpass = walletpass;
        this.walletcount = walletcount;
    }

    public WalletDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWalletname() {
        return walletname;
    }

    public void setWalletname(String walletname) {
        this.walletname = walletname;
    }

    public String getWalletpass() {
        return walletpass;
    }

    public void setWalletpass(String walletpass) {
        this.walletpass = walletpass;
    }

    public String getWalletcount() {
        return walletcount;
    }

    public void setWalletcount(String walletcount) {
        this.walletcount = walletcount;
    }

    private Long id;
    private String walletname;
    private String walletpass;
    private String walletcount;
}
