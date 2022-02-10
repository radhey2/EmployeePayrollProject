package com.bridegelabz.employeepayrollapp.controllers;


import com.bridegelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridegelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridegelabz.employeepayrollapp.entity.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Introducing DTO and Model to Employee Payroll

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO>  getEmployeePayrollData(){
        EmployeePayrollData empData= null;
        empData = new EmployeePayrollData(1, new EmployeePayrollDTO("Pankaj", 30000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping( "/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
        EmployeePayrollData empData= null;
        empData = new EmployeePayrollData(empId, new EmployeePayrollDTO("Pankaj", 30000));
        ResponseDTO responseDTO = new ResponseDTO("Get Call for ID Successful",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeeDTO){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create Employee Payroll Data for: ", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeeDTO){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll Data for: ", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted id: "+empId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


}
