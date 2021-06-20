package com.n26;

import com.n26.daemon.TransactionsCleaner;
import com.n26.service.impl.TransactionServiceImpl;
import com.n26.utils.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
        TransactionsCleaner cleaner = new TransactionsCleaner(Constants.TRANSACTION_CLEANER_DAEMON);
        cleaner.start();
    }

}
