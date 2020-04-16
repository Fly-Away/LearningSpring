package com.api.b2b.Repository;

import java.util.*;

import com.api.b2b.Model.Account;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import static java.util.stream.Collectors.toList;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    List<Account> findByaccountId(String account_id);

    Optional<Account> findByaccountIdIgnoreCase(String account_id);

    // List<Account> findByaccountname(String account_name, Pageable pageable);
    List<Account> findByaccountNameStartsWithIgnoreCase(String account_name);

    // @Query(value = "SELECT * FROM ms_account WHERE account_email LIKE %:accountEmail%", nativeQuery = true)
    // @Query(value = "SELECT a.account_name,b.dealer_name FROM ms_account a inner join ms_dealer b on a.account_id = b.account_id WHERE account_email LIKE %:accountEmail%", nativeQuery = true)
    @Query(value = "SELECT msa FROM Account msa WHERE msa.accountEmail LIKE %:accountEmail%")
    List<Account> searchByaccountEmail(@Param("accountEmail") String accountEmail);

    Boolean existsAccountByaccountId(String accountId);

    void deleteByaccountId(String accountId);
    
    
    // private Map<Long, Account> accounts = new HashMap<>();

    // public Optional<Account> findById(long id) {
    //     return Optional.ofNullable(accounts.get(id));
    // }

    // public void add(Account account) {
    //     accounts.put(account.getId(), account);
    // }

    // public Collection<Account> getAccounts() {
    //     return accounts.values();
    // }

    // public Page<Account> getAccounts(Pageable pageable){
    //     int toSkip = pageable.getPageSize() * pageable.getPageNumber();
    //     List<Account> result = accounts.values().stream().skip(toSkip).limit(pageable.getPageSize()).collect(toList());

    //     return new PageImpl<>(result, pageable, accounts.size());
    // }
}