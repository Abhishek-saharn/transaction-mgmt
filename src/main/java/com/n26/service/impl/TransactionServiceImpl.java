package com.n26.service.impl;

import com.n26.exception.InvalidTransactionParamsException;
import com.n26.model.Transaction;
import com.n26.service.TransactionService;
import com.n26.utils.Helper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TransactionServiceImpl implements TransactionService {

    public static final Logger logger = Logger.getLogger(Transaction.class.toString());
    @Override
    public HttpStatus createTransaction(String amountString, String timestampString) {
        try {
            BigDecimal amount = new BigDecimal(amountString);

            TemporalAccessor ta = DateTimeFormatter.ISO_INSTANT.parse(timestampString);
            Instant instant = Instant.from(ta);
            Date transactionDate = Date.from(instant);
            Long transactionTimestamp = transactionDate.getTime();

            //validate time provided
            if(!Helper.isValidTime(transactionTimestamp))
            {
                logger.log(Level.INFO, "TransactionServiceImpl.createTransaction: Not valid timestamp");
                return HttpStatus.NO_CONTENT;
            }
            Transaction transaction = new Transaction(amount, transactionDate);

            TRANSACTION_MAP.put(transaction, transactionTimestamp);
            logger.log(Level.INFO, "TransactionServiceImpl.createTransaction: Transaction Created : Map: " + Arrays.toString(TRANSACTION_MAP.entrySet().toArray()));

        }
        catch (NumberFormatException nfe)
        {
            throw new InvalidTransactionParamsException(nfe.getMessage());
        }
        catch (DateTimeParseException parseException)
        {
            throw new InvalidTransactionParamsException(parseException.getMessage());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw exception;
        }
        return HttpStatus.CREATED;
    }

    @Override
    public void deleteTransactions() {
        TRANSACTION_MAP.clear();
    }
}
