package com.n26.service.impl;

import com.n26.model.Statistic;
import com.n26.model.Transaction;
import com.n26.service.StatisticsService;
import com.n26.service.TransactionService;
import com.n26.utils.Helper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Override
    public Statistic getStatistics() {
        BigDecimal avg = new BigDecimal(0.00);
        BigDecimal sum = new BigDecimal(0.00);
        BigDecimal max = new BigDecimal(Integer.MIN_VALUE);
        BigDecimal min = new BigDecimal(Integer.MAX_VALUE);
        Long count = 0l;

        //get copy of transaction this time, and calculate stats
        Map<Transaction, Long> transactions = TransactionService.TRANSACTION_MAP;
        for (Map.Entry<Transaction, Long> transaction : transactions.entrySet()) {
            Transaction transactionObj = transaction.getKey();
            Long timestamp = transaction.getValue();

            if (!Helper.isValidTime(timestamp)) continue;

            BigDecimal amount = transactionObj.getAmount();
            count += 1;
            max = max.max(amount).setScale(2,RoundingMode.HALF_UP);
            min = min.min(amount).setScale(2,RoundingMode.HALF_UP);
            sum = sum.add(amount).setScale(2, RoundingMode.HALF_UP);
        }

        if (count > 0) {
            avg = sum.divide(new BigDecimal(count), 2, RoundingMode.HALF_UP);
        }

        return new Statistic(sum,
                avg,
                (max.intValue()==Integer.MIN_VALUE) ? new BigDecimal(0.00): max,
                (min.intValue()==Integer.MAX_VALUE) ? new BigDecimal(0.00): min,
                count);
    }
}
