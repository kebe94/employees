package com.kebe94.employees.employee.service;


import com.kebe94.employees.department.DepartmentRepository;
import com.kebe94.employees.dto.EmployeeResponsePages;
import com.kebe94.employees.employee.Employee;
import com.kebe94.employees.employee.EmployeeRepository;
import com.kebe94.employees.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @Override
    public Employee saveEmployee(Employee employeeRequest) {
      //  Employee employee = employeeRepository.getById(employeeRequest.getEmployeeId());
        employeeRequest.setCreateDate(new Date());
        Employee save = employeeRepository.save(employeeRequest);
      
        return save;
    }

    @Override
    public Employee getEmployee(Long employeeId) {

     try {
         Employee employee = employeeRepository.findById(employeeId).get();
         return employee;
     } catch (Exception e) {
         throw new ResourceNotFoundException("erreur 404 page introuvable");
     }
    }



    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteEmployee(Long employeeId) {

        Optional<Employee> existingEmployee = employeeRepository.findById(employeeId);
         if (existingEmployee.isPresent()){
             employeeRepository.deleteById(existingEmployee.get().getEmployeeId());
             return ResponseEntity.ok().build();
         }
        return ResponseEntity.notFound().build();
    }

    @Override
    public EmployeeResponsePages searchEmployeeLastName(String mc, int page, int size) {
        Page<Employee> employees = employeeRepository.searchEmployeeLastName(mc, PageRequest.of(page, size));
        EmployeeResponsePages employeeResponse = new EmployeeResponsePages();
        employeeResponse.setEmployees(employees.getContent());
        employeeResponse.setPage(employees.getNumber());
        employeeResponse.setTotalPages(employees.getTotalPages());
        employeeResponse.setCurrentPage(page);
        return employeeResponse;

    }


}
