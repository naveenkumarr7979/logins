package com.app.logins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginsApplication {

    private static  final Logger logger= LoggerFactory.getLogger(LoginsApplication.class);
    public static void main(String[] args) {
        logger.info("Inside LoginsApplication root class");
        SpringApplication.run(LoginsApplication.class, args);
	}

}
