package com.kebe94.employees.employee.service;

import com.kebe94.employees.dto.EmployeeResponsePages;
import com.kebe94.employees.employee.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long employeeId);


    List<Employee> getAllEmployee();

    ResponseEntity<String> deleteEmployee(Long employeeId);

    EmployeeResponsePages searchEmployeeLastName(String mc, int page, int size);

}
