package com.kebe94.employees.department.service;


import com.kebe94.employees.department.Department;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    Department getDepartment(Long departmentId);

    List<Department> getAllDepartment();


    ResponseEntity<String> deleteDepartment(Long departmentId);


}
