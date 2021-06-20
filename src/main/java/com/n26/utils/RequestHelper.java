package com.n26.utils;

import java.util.*;

public class RequestHelper {

    public static boolean isValidTransaction(Map<String, String> reqParams)
    {
        if(reqParams.size() == Constants.TRANSACTION_REQ_SIZE
                && validKeyParams(reqParams.keySet(), Arrays.asList(Constants.TRANSACTION_VALID_REQ_KEYS)))
        {
            return true;
        }
        return false;
    }

    public static boolean validKeyParams(Set<String> paramKeys, List<String> validKeys)
    {

        for (String  key : paramKeys ) {
            if(!validKeys.contains(key))
            {
                return false;
            }
        }
        return true;
    }
}
