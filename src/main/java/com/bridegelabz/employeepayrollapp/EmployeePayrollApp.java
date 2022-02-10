package com.bridegelabz.employeepayrollapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeePayrollApp {

    public static void main(String[] args) {

        SpringApplication.run(EmployeePayrollApp.class, args);
        log.info("Employee Payroll App Started");
    }

}
