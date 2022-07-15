package ch.zli.gameapi.character;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController for
 * @author RiceDefender
 * @date 15.07.2022
 *
 */


@RestController
@RequestMapping("/characters")
public class CharacterController {

	@Autowired
    private CharacterRepository characterRepository;

    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }
    

    @GetMapping
    public List<Character> getTasks() {
        return characterRepository.findAll();  //find all accounts
    }
    

    @PostMapping
    public void addAccount(@RequestBody Character character) {
        characterRepository.save(character);
    }



    @PutMapping("/{id}")
    public void editTask(@PathVariable long id, @RequestBody Character character) {
        Assert.notNull(characterRepository.findById(id).get(), "Character not found");
        characterRepository.findById(id).get().setCharacterName(character.getCharacterName());
        characterRepository.findById(id).get().setCharacterClass(character.getCharacterClass());
        characterRepository.save(character);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
        Character character = characterRepository.findById(id).get();
        characterRepository.delete(character);
    }
}