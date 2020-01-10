package com.ipaynow.bcfinance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.ipaynow.bcfinance.dao")
@EnableTransactionManagement
public class BcFinanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BcFinanceApplication.class, args);
    }

}
