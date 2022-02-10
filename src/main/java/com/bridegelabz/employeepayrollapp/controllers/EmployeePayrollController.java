package com.bridegelabz.employeepayrollapp.controllers;


import com.bridegelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridegelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridegelabz.employeepayrollapp.entity.EmployeePayrollData;
import com.bridegelabz.employeepayrollapp.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Introducing Service Layer in EmployeePayrollApp

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO>  getEmployeePayrollData(){
        List<EmployeePayrollData> empList = null;
        empList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success",empList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping( "/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
        EmployeePayrollData empData= null;
        empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for ID Successful",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeeDTO){
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create Employee Payroll Data for: ", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,@RequestBody EmployeePayrollDTO employeeDTO){
        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(empId, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data for: ", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted id: "+empId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


}
