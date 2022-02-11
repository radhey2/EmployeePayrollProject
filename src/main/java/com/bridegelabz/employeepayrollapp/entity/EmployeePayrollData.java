package com.bridegelabz.employeepayrollapp.entity;

import com.bridegelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Table(name = "employee_payroll")
@Data
public class EmployeePayrollData {
    AtomicLong atomicLong = new AtomicLong();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private long employeeId;

    @Column(name = "name")
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;


    public EmployeePayrollData() { }
    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){
        this.updateEmployeePayrollData(employeePayrollDTO);
    }

    public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = atomicLong.incrementAndGet();
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender = employeePayrollDTO.gender;
        this.note = employeePayrollDTO.note;
        this.profilePic = employeePayrollDTO.profilePic;
        this.startDate = employeePayrollDTO.startDate;
        this.departments = employeePayrollDTO.department;
    }
}
