package com.bridegelabz.employeepayrollapp.controllers;


import com.bridegelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<String>  getEmployeePayrollData(){
        return new ResponseEntity<String>("Get Call Success",HttpStatus.OK);
    }

    @GetMapping( "/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId){
        return new ResponseEntity<String >("Get Call Successful at ID: "+empId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeeDTO){
        return new ResponseEntity<String>("Create Employee Payroll Data for: "+employeeDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeeDTO){
        return new ResponseEntity<String>("Updated Employee Payroll Data for: "+employeeDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        return new ResponseEntity<String>("Deleted Employee Payroll Data for: "+empId, HttpStatus.OK);
    }


}
