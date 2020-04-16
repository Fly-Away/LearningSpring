package com.api.b2b.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.api.b2b.Exception.AccountNotFoundException;
import com.api.b2b.Exception.ResourceAlreadyExistException;
import com.api.b2b.Model.Account;
import com.api.b2b.Model.Dealer;
import com.api.b2b.Model.Product;
import com.api.b2b.Repository.AccountRepository;
import com.api.b2b.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    private boolean existsById(String id) {
        return accountRepository.existsAccountByaccountId(id);
    }

    public List<Account> findAll(int pageNumber, int rowPerPage) {
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll(PageRequest.of(pageNumber - 1, rowPerPage)).forEach(accounts::add);
        return accounts;
    }

    public Account findById(String accountId) {
        Account account = accountRepository.findByaccountIdIgnoreCase(accountId).orElseThrow(() -> new AccountNotFoundException("Data tidak ditemukan!"));
        return account;
    }
    
    // public List<Account> findByName(String name, int pageNumber, int rowPerPage) {
    //     List<Account> accounts = new ArrayList<>();
    //     accountRepository.findByaccountname(name, PageRequest.of(pageNumber - 1, rowPerPage)).forEach(accounts::add);
    //     return accounts;
    // }

    public List<Account> findByName(String name) {
        List<Account> accounts = new ArrayList<>();
        accounts = accountRepository.findByaccountNameStartsWithIgnoreCase(name);
        return accounts;
    }

    public List<Account> findByaccountEmail(String name) {
        List<Account> accounts = new ArrayList<>();
        accounts = accountRepository.searchByaccountEmail(name);
        return accounts;
    }

    public Account save(Account account) {
        if(existsById(account.getAccountId())){
            throw new ResourceAlreadyExistException("ID "+ account.getAccountId() +" sudah ada!");
        }

        account.getDealer().forEach(d -> d.setAccount(account));

        return accountRepository.save(account);
    }

    public void update(Account account) throws AccountNotFoundException {
        // if(account.getAccountname().isEmpty()) {

        // }

        if(!existsById(account.getAccountId())){
            throw new AccountNotFoundException("ID "+ account.getAccountId() +" tidak di temukan");
        }
        accountRepository.save(account);
    }

    public void updateEmail(String accountId, Account account) throws AccountNotFoundException {
        Account accountNew = findById(accountId);

        accountNew.setAccountEmail(account.getAccountEmail());
        accountRepository.save(accountNew);
    }

    public void deleteAccountById(String id) throws AccountNotFoundException {
        if(!existsById(id)){
            throw new AccountNotFoundException("ID "+ id +" tidak di temukan");
        }

        accountRepository.deleteByaccountId(id);
    }

}