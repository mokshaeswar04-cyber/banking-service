package com.tcs.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BankTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;
    private String type;
    private Double amount;
    private LocalDateTime date;

    public BankTransaction() {}

    public BankTransaction(Long accountId, String type, Double amount, LocalDateTime date) {
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    // getters and setters
    public Long getId() { return id; }
    public Long getAccountId() { return accountId; }
    public String getType() { return type; }
    public Double getAmount() { return amount; }
    public LocalDateTime getDate() { return date; }

    public void setId(Long id) { this.id = id; }
    public void setAccountId(Long accountId) { this.accountId = accountId; }
    public void setType(String type) { this.type = type; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setDate(LocalDateTime date) { this.date = date; }
}
