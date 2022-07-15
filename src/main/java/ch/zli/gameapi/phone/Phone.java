package ch.zli.gameapi.phone;

import ch.zli.gameapi.account.Account;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String phoneName;
    private PhoneOS os;

    @ManyToOne
    @JoinColumn(name="account_id", nullable=true)
    private Account accountFK;

    //Constructors
    protected Phone() { }

    public Phone(String phoneName) {
        this.phoneName = phoneName;
    }

    public Phone(String phoneName, PhoneOS os) {
        this.phoneName = phoneName;
        this.os = os;
    }

    public Phone(String phoneName, PhoneOS os, Account accountFK) {
        this.phoneName = phoneName;
        this.os = os;
        this.accountFK = accountFK;
    }

    //Getter and Setter
    public long getId() {
        return id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public PhoneOS getOs() {
        return os;
    }

    public void setOs(PhoneOS os) {
        this.os = os;
    }

    public Account getAccountFK() {
        return accountFK;
    }

    public void setAccountFK(Account accountFK) {
        this.accountFK = accountFK;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phoneName='" + phoneName + '\'' +
                ", os=" + os +
                ", accountFK=" + accountFK +
                '}';
    }

}