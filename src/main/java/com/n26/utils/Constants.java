package com.n26.utils;

public class Constants {
    public static final int ALLOWED_TIMESTAMP_DIFF = 60 * 1000; // 60 secs
    public static final int TRANSACTION_REQ_SIZE = 2;
    public static final String[] TRANSACTION_VALID_REQ_KEYS = new String[]{"amount", "timestamp"};
    public static final String TRANSACTION_CLEANER_DAEMON = "Transaction cleaner daemon";
}
