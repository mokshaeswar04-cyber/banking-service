package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tcs.entity.Account;
import com.tcs.service.BankService;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/deposit/{id}")
    public Account deposit(@PathVariable Long id, @RequestParam Double amount) {
        return bankService.deposit(id, amount);
    }

    @PostMapping("/withdraw/{id}")
    public Account withdraw(@PathVariable Long id, @RequestParam Double amount) {
        return bankService.withdraw(id, amount);
    }
    @PostMapping("/create")
    public Account createAccount(@RequestParam String name,
                                 @RequestParam Double initialBalance) {
        return bankService.createAccount(name, initialBalance);
    }

}
