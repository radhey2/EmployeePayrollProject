package com.example.employeepayroll.Service;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.modal.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();

    List<EmployeePayrollData>getEmployeeByDepartment(String department);

    EmployeePayrollData updateEmployeePayrollData(int empID, EmployeePayrollData empPayrollDTO);


    EmployeePayrollData getEmployeePayrollDataById(int empID);

    EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int empID);
}
