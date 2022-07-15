package ch.zli.gameapi.account;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String Email_Address;

    private String Accountname;

    public long getId() {
        return id;
    }

    public Account() {
    }

    public Account(String email_Address, String accountname) {
        Email_Address = email_Address;
        Accountname = accountname;
    }

    public Account(String accountname) {
        Accountname = accountname;
    }

    /**
     * FK not implemented yet because classes arent implemented yet.
     */




    //Getter and Setter

    public String getEmail_Address() {
        return Email_Address;
    }

    public void setEmail_Address(String email_Address) {
        Email_Address = email_Address;
    }

    public String getAccountname() {
        return Accountname;
    }

    public void setAccountname(String accountname) {
        Accountname = accountname;
    }
}