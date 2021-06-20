package com.n26.service;

import com.n26.model.Transaction;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public interface TransactionService {

    public static final Map<Transaction, Long> TRANSACTION_MAP = new ConcurrentHashMap(100);

    //creates transactions
    public HttpStatus createTransaction(String amount, String timestamp);

    //delete all the transactions
    public void deleteTransactions();
}
