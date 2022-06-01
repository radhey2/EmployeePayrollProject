package com.example.employeepayroll.Controller;

import com.example.employeepayroll.Service.IEmployeePayrollService;
import com.example.employeepayroll.dto.EmployeePayrollDTO;
import com.example.employeepayroll.dto.ResponseDTO;
import com.example.employeepayroll.modal.EmployeePayrollData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayroll_service")
@Slf4j
public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> empdataList =null;
        empdataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Succcessfull",empdataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empID}")
    public ResponseEntity<ResponseDTO>getEmployeePayrollData(@PathVariable("empID") int empID){
        EmployeePayrollData empdata =null;
        empdata = employeePayrollService.getEmployeePayrollDataById(empID);
        ResponseDTO respDTO = new ResponseDTO("Get Call For Id SuccessFull", empdata);
        return new ResponseEntity<ResponseDTO>( respDTO, HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO>getEmployeePayrollData(@PathVariable("department") String department){
        List<EmployeePayrollData> empdataList =null;
        empdataList = employeePayrollService.getEmployeeByDepartment(department);
        ResponseDTO respDTO = new ResponseDTO("Get Call For Id Successfull", empdataList);
        return new ResponseEntity<ResponseDTO>( respDTO, HttpStatus.OK);
    }

    @PostMapping("/Create")
    public ResponseEntity<ResponseDTO>addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData empdata =null;
        empdata = employeePayrollService.addEmployeePayrollData(employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Create EmployeePayroll Data SuccessFully: ", empdata);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empID}")
    public ResponseEntity<ResponseDTO>updateEmployeePayrollData(@PathVariable int empID,@RequestBody EmployeePayrollData employeePayrollDTO){
        EmployeePayrollData empdata =null;
        empdata = employeePayrollService.updateEmployeePayrollData(1,employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Update EmployeePayroll data for  ", empdata);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empID}")
    public ResponseEntity<ResponseDTO>deleteEmployeePayrollData(@PathVariable("empID") int empID){
        ResponseDTO respDTO = new ResponseDTO("Delete Id Successfully ", +empID);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
