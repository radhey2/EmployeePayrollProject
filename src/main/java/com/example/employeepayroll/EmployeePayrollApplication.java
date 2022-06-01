package com.example.employeepayroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EmployeePayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeePayrollApplication.class, args);
//        log.info("EmployeePayrollApp Has Started in {} Environment",context.getEnvironment().getProperty("environment"));
//        log.info("EmployeePayroll DB User is {}",context.getEnvironment().getProperty("spring.datasource.username"));
    }
}