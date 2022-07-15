package ch.zli.gameapi.phone;

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
 * RestController für 
 * @author luigicavuoti
 * @date 10.07.2020
 *
 */
@RestController
@RequestMapping("/phones")
public class PhoneController {

	@Autowired
    private PhoneRepository phoneRepository;

    public PhoneController(PhoneRepository taskRepository) {
        this.phoneRepository = taskRepository;
    }
    

    @GetMapping
    public List<Phone> getTasks() {
        return phoneRepository.findAll();  //taskRepository.findAll();
    }
    

    @PostMapping
    public void addTask(@RequestBody Phone phone) {
        phoneRepository.save(phone);
    }



    @PutMapping("/{id}")
    public void editPhone(@PathVariable long id, @RequestBody Phone phone) {

        phoneRepository.findById(id).get().setPhoneName(phone.getPhoneName());
        phoneRepository.save(phoneRepository.findById(id).get());
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
        Phone delete = phoneRepository.findById(id).get();
        phoneRepository.delete(delete);
    }
}