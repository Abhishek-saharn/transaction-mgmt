package com.n26.daemon;

import com.n26.exception.GlobalTransactionException;
import com.n26.model.Transaction;
import com.n26.service.impl.TransactionServiceImpl;
import com.n26.utils.Constants;
/**** this thread will keep checking the transactions which are expired ****/
public class TransactionsCleaner extends Thread{

    public TransactionsCleaner(String threadName)
    {
        super(threadName);
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!TransactionServiceImpl.TRANSACTION_MAP.isEmpty()) {
                    TransactionServiceImpl.TRANSACTION_MAP.values().removeIf(value -> (System.currentTimeMillis() - value) > Constants.ALLOWED_TIMESTAMP_DIFF);
                }
                Thread.sleep(Constants.DAEMON_DELAY_TIME);
            }
        }
        catch (Exception exception)
        {
            throw new GlobalTransactionException(exception.getMessage());
        }
    }
}
