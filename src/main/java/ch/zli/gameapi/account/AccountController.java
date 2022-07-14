package ch.zli.gameapi.account;

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


@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
    private AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    

    @GetMapping
    public List<Account> getTasks() {
        return accountRepository.findAll();  //find all accounts
    }
    

    @PostMapping
    public void addAccount(@RequestBody Account account) {
        accountRepository.save(account);
    }



    @PutMapping("/{id}")
    public void editTask(@PathVariable long id, @RequestBody Account account) {
        Account existingTask = accountRepository.findById(id).get();
        Assert.notNull(accountRepository.findById(id).get(), "Task not found");
        accountRepository.findById(id).get().setAccountname(account.getAccountname());
        accountRepository.save(existingTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
        Account deleteaccount = accountRepository.findById(id).get();
        accountRepository.delete(deleteaccount);
    }
}