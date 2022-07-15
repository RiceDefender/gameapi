package ch.zli.gameapi.character;

import org.springframework.lang.Nullable;

import javax.persistence.*;


@Entity
@Table(name = "chara")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = true)
    private String characterName;


    @Column(nullable = true)
    private CharacterClass characterClass;




    /**
     * FK not implemented yet because classes arent implemented yet.
     */

    public Character() {
        super();
    }

    public Character(String characterName) {
        super();
        this.characterName = characterName;
    }
    public Character(String characterName, CharacterClass characterClass) {
        super();
        this.characterName = characterName;
        this.characterClass = characterClass;
    }

    //Getter and Setter
    public long getId() {
        return id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }
}