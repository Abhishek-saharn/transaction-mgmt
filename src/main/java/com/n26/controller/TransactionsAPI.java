package com.n26.controller;

import com.n26.model.Transaction;
import com.n26.service.TransactionService;
import com.n26.utils.RequestHelper;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/")
public class TransactionsAPI {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transactions")
    public ResponseEntity<String> createTransaction(@RequestBody @Valid Map<String, String> reqParams)
    {
        if(!RequestHelper.isValidTransaction(reqParams))
        {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        String amount = reqParams.get("amount");
        String timestamp = reqParams.get("timestamp");
        return new ResponseEntity(transactionService.createTransaction(amount,timestamp));
    }

    @DeleteMapping("/transactions")
    public ResponseEntity<String> deleteTransactions()
    {
        transactionService.deleteTransactions();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
