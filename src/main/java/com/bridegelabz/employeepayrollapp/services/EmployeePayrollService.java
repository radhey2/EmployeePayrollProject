package com.bridegelabz.employeepayrollapp.services;

import com.bridegelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridegelabz.employeepayrollapp.entity.EmployeePayrollData;
import com.bridegelabz.employeepayrollapp.exceptions.EmployeePayrollException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Adding the ability for the Services Layer to store the Employee Payroll Data
@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.stream().filter(empData -> empData.getEmployeeId() == empId)
                .findFirst().orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));

    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(employeePayrollList.size()+1, employeePayrollDTO);
        employeePayrollList.add(empData);
        return empData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeeData = employeePayrollList.stream().filter(empData -> empData.getEmployeeId() == empId)
                .findFirst().orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
        employeeData.setName(employeePayrollDTO.name);
        employeeData.setSalary(employeePayrollDTO.salary);
        employeePayrollList.set(empId-1, employeeData);
        return employeeData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData employeeData = employeePayrollList.stream().filter(empData -> empData.getEmployeeId() == empId)
                .findFirst().orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
        employeePayrollList.remove(empId-1);
    }
}
