package com.n26.utils;

import com.n26.exception.InvalidTransactionParamsException;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Helper {

    public static boolean isValidTime(Long timestamp)
    {
        Long currentTimestamp = System.currentTimeMillis();
        if(timestamp > currentTimestamp)
        {
            throw new InvalidTransactionParamsException("POST: /transactions : Future time not allowed");
        }
        if((currentTimestamp - timestamp) > Constants.ALLOWED_TIMESTAMP_DIFF)
        {
            return false;
        }
        return true;
    }

}
