package com.bridegelabz.employeepayrollapp.entity;

import com.bridegelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeePayrollData {

    private int employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> department;


    public EmployeePayrollData() { }

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.note = employeePayrollDTO.note;
        this.profilePic = employeePayrollDTO.profilePic;
        this.startDate = employeePayrollDTO.startDate;
        this.department = employeePayrollDTO.department;
    }
}
