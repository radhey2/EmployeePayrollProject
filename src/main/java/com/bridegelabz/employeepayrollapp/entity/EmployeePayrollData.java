package com.bridegelabz.employeepayrollapp.entity;

import com.bridegelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

@Data
public class EmployeePayrollData {

    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
    }
}
