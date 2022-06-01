package com.example.employeepayroll.Repository;

import com.example.employeepayroll.modal.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {
    @Query(value = "select + employee_Payroll, employee_department where employee_Id = Id and Department = :department",nativeQuery = true)
    List<EmployeePayrollData> findEmployeeByDepartment(String department);
}
