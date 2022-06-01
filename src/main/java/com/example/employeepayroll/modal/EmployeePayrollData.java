package com.example.employeepayroll.modal;

import com.example.employeepayroll.dto.EmployeePayrollDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
@Data
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_Id")

    private int employeeId;
    private long salary;
    private String name;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String ProfilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(EmployeePayrollData employeePayrollDTO) {
        this.updateEmployeePayrollData(employeePayrollDTO);
    }

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
    }

    public void updateEmployeePayrollData(EmployeePayrollData employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.gender = employeePayrollDTO.gender;
        this.startDate = employeePayrollDTO.startDate;
        this.note = employeePayrollDTO.note;
        this.departments = employeePayrollDTO.departments;
        this.ProfilePic = employeePayrollDTO.ProfilePic;
        this.salary = employeePayrollDTO.salary;
    }

}
