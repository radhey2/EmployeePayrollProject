package com.bridegelabz.employeepayrollapp.services;

import com.bridegelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridegelabz.employeepayrollapp.entity.EmployeePayrollData;
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
        return employeePayrollList.get(empId-1);
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
        EmployeePayrollData empData = employeePayrollList.get(empId-1);
        empData.setName(employeePayrollDTO.name);
        empData.setSalary(employeePayrollDTO.salary);
        employeePayrollList.set(empId-1, empData);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId-1);
    }
}
