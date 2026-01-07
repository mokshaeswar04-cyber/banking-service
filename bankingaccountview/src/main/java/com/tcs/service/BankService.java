package com.tcs.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.entity.Account;
import com.tcs.entity.BankTransaction;
import com.tcs.repository.AccountRepository;
import com.tcs.repository.BankTransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class BankService {

    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private BankTransactionRepository transactionRepo;

    @Transactional
    public Account deposit(Long id, Double amount) {
        Account acc = accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        acc.setBalance(acc.getBalance() + amount);

        transactionRepo.save(new BankTransaction(id, "DEPOSIT", amount, LocalDateTime.now()));
        return accountRepo.save(acc);
    }

    @Transactional
    public Account withdraw(Long id, Double amount) {
        Account acc = accountRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (acc.getBalance() < amount) throw new RuntimeException("Insufficient balance");

        acc.setBalance(acc.getBalance() - amount);
        transactionRepo.save(new BankTransaction(id, "WITHDRAW", amount, LocalDateTime.now()));
        return accountRepo.save(acc);
        
    }
    @Transactional
    public Account createAccount(String name, Double initialBalance) {
        Account acc = new Account();
        acc.setName(name);
        acc.setBalance(initialBalance);
        return accountRepo.save(acc);
    }

}
