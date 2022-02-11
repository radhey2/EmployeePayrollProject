package com.bridegelabz.employeepayrollapp.dto;

import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@ToString
public class EmployeePayrollDTO {
    @NotEmpty(message="Employee name cannot be empty")
    @Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;

    @Min(value =  500, message = "Min wage should be more than 500")
    public long salary;

    public String gender;

    public LocalDate startDate;

    public String note;

    public String profilePic;

    public List<String> department;

}
