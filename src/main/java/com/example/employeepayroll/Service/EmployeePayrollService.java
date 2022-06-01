package com.example.employeepayroll.Service;

import com.example.employeepayroll.Exception.EmployeePayrollException;
import com.example.employeepayroll.Repository.EmployeePayrollRepository;
import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.modal.EmployeePayrollData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {

        return employeePayrollRepository.findAll();
    }
    @Override
    public List<EmployeePayrollData> getEmployeeByDepartment(String department) {
        return employeePayrollRepository.findEmployeeByDepartment(department);
    }
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empID, EmployeePayrollData empPayrollDTO) {
        EmployeePayrollData empData= this.getEmployeePayrollDataById(empID);
        empData.updateEmployeePayrollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
    }
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empID) {
        return employeePayrollRepository
                .findById(empID)
                .orElseThrow(()->new EmployeePayrollException("Employee with id" +empID + "does not exist"));
    }
    @Override
    public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(employeePayrollDTO);
        log.debug("Emp Data : "+empData.toString());
        return employeePayrollRepository.save(empData);

    }

    @Override
    public void deleteEmployeePayrollData(int empID) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empID);
        employeePayrollRepository.delete(empData);
    }
}
