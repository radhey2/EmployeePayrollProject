package com.bridegelabz.employeepayrollapp.repository;

import com.bridegelabz.employeepayrollapp.entity.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {
}
