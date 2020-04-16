package com.api.b2b.Controller;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import com.api.b2b.Exception.AccountNotFoundException;
import com.api.b2b.Exception.ResourceAlreadyExistException;
import com.api.b2b.Model.Account;
import com.api.b2b.Repository.AccountRepository;
import com.api.b2b.Services.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

// import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final int ROW_PER_PAGE = 10;

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> findById(@PathVariable String accountId) {

            Account account = accountService.findById(accountId);
            return ResponseEntity.ok(account);
    }

    @GetMapping("/{pageNumber}/all")
    public ResponseEntity<Collection<Account>> findAllAccounts(@PathVariable int pageNumber) {

        return ResponseEntity.ok(accountService.findAll(pageNumber, ROW_PER_PAGE));
        
    }

    // @GetMapping("/{pageNumber}/{name}")
    // public ResponseEntity<Collection<Account>> findAccounts(@PathVariable int pageNumber, @PathVariable String name) {
        
    //     return ResponseEntity.ok(accountService.findByName(name, pageNumber, ROW_PER_PAGE));
        
    // }

    @Operation(summary = "Search based on name", description = "format pencarian menggunakan =name", tags = { "Search" })
    @GetMapping("/name/{name}")
    public ResponseEntity<Collection<Account>> findAccounts(@PathVariable String name) {
        
        return ResponseEntity.ok(accountService.findByName(name));
        
    }

    @Operation(summary = "Search based on email", description = "format pencarian menggunakan %email%", tags = { "Search" })
    @GetMapping("/email/{email}")
    public ResponseEntity<Collection<Account>> findAccountsByEmail(@Parameter(description="Tidak perlu format lengkap, hanya keyword cukup", 
    required=true) @PathVariable String email) {
        try {
            Collection<Account> accounts = accountService.findByaccountEmail(email);
            return ResponseEntity.ok(accounts);
        } catch (AccountNotFoundException ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.notFound().build();
        }
        
        
    }

    @Operation(summary = "Create New Account", description = "Simpan account baru", tags = { "CRUD Account" })
    @PostMapping("/new")
    public ResponseEntity<Account> addAccount(@Valid @RequestBody Account account) {
        // try {
            // account.getDealer().forEach(d -> d.setAccount(account));
            Account newAccount = accountService.save(account);
            return ResponseEntity.ok(newAccount);
        // } catch(Exception ex) {
        //     //log exceptionnya disini dgn logger
        //     logger.error(ex.getMessage());
        //     throw new ResourceAlreadyExistException(ex.getMessage());
        // }
    }

    @Operation(summary = "Update Existing Account", description = "update data account harus masukin semua field di body", tags = { "CRUD Account" })
    @PutMapping("/accounts/{accountId}")
    public ResponseEntity<Account> updateAccount(@Valid @RequestBody Account account, @PathVariable String accountId ) {
        try {
            account.setAccountId(accountId);
            accountService.update(account);
            return ResponseEntity.ok().build();
        } catch (AccountNotFoundException ex) {
            logger.error(ex.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Update Email based on accountId", description = "hanya perlu masukin body accountEmail", tags = { "CRUD Account" })
    @PatchMapping("/accounts/{accountId}")
    public ResponseEntity<Account> updateEmail(@RequestBody Account account, @PathVariable String accountId){
        try {
            accountService.updateEmail(accountId, account);
            return ResponseEntity.ok().build();
        } catch(AccountNotFoundException ex){
            logger.error(ex.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete account based on accountId", description = "format delete berdasarkan =accountId", tags = { "CRUD Account" })
    @DeleteMapping("/accounts/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String accountId){
        try {

            accountService.deleteAccountById(accountId);
            return ResponseEntity.ok().build();
        } catch(AccountNotFoundException ex){
            logger.error(ex.getMessage());
            return ResponseEntity.notFound().build();
        }
    }


    // @PutMapping("/{id}")
    // @ResponseStatus(HttpStatus.OK)
    // public Account updateAccount(@PathVariable("id") final String id,@RequestBody final Account account) {
    //     //final menandakan nilai mutlak, tidak bisa di assign / rubah lagi
    //     //cth
    //     //id = "balabala";
    //     //bakal error
    //     return account;
    // }

    // @GetMapping("/filter")
    // public Page<Account> filterBooks(Pageable pageable) {
    //     return accountRepository.getAccounts(pageable);
    // }

}