package ch.zli.gameapi.account;

import ch.zli.gameapi.character.Character;
import ch.zli.gameapi.phone.Phone;
import ch.zli.gameapi.profile.Profile;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String Email_Address;

    private String Accountname;

    @ManyToOne
    private Character character;

    @ManyToOne
    private Profile profile;

    //@OneToMany(mappedBy = "account")
    //private List<Phone> phones;

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

    public Account(String email_Address, String accountname, Character character, Profile profile) {
        Email_Address = email_Address;
        Accountname = accountname;
        this.character = character;
        this.profile = profile;
    }

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

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}