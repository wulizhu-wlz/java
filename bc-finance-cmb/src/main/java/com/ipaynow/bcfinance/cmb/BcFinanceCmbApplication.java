package com.ipaynow.bcfinance.cmb;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.ipaynow.bcfinance.dao")
@EnableTransactionManagement
@EnableConfigurationProperties
@EnableScheduling
public class BcFinanceCmbApplication {

    public static void main(String[] args) {
        SpringApplication.run(BcFinanceCmbApplication.class, args);
    }

}
