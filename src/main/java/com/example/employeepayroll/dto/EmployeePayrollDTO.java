package com.example.employeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@ToString
public class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z{1}[a-zA-z\\s]{2,}$",
            message = "Employee Name Invalid")
    public String Name;

    @Min(value = 500, message = "Min wage Should more than 500")
    public long salary;

    @Pattern(regexp = "male | female",message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "Start date should not be null")
    @PastOrPresent(message = "Start date should be past or todays date")
    public LocalDate startDate;

    @NotBlank(message = "Note can not be Empty")
    public String note;

    @NotBlank(message = "ProfilePic Cannot be Empty")
    public String ProfilePic;

    @NotNull(message = "department sholud not be Empty")
    public List<String> departments;


}
