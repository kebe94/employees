package com.kebe94.employees.dto;



import com.kebe94.employees.department.Department;
import com.kebe94.employees.employee.Employee;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EmployeeResponsePages {
//    private Long employeeId;
//    private String fonction;
//    private String email;
//    private float vacationBalance;
//    private Date hiringDate;
//    private Department department;
    private List<Employee> employees;

    private  int totalPages;
    private int currentPage;
    private int pageSize;
    private  int page;




}
