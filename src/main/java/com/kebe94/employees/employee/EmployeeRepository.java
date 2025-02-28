package com.kebe94.employees.employee;


import com.kebe94.employees.department.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

//    @Query("SELECT  p FROM Employee p WHERE  p.lastName like:mc and p.department.emailManager =:email")
    @Query("SELECT  p FROM Employee p WHERE  p.lastName like:mc")

    Page<Employee> searchEmployeeLastName(@Param("mc") String mc, Pageable pageable);

    @Query("SELECT  e FROM Employee e WHERE   e.department.emailManager =:email")

    List<Employee> findAllEmployees(String email);
    @Query("SELECT  p FROM Employee p WHERE  p.employeeId =:employeeId and p.department.emailManager =:email")
    Employee findEmployeeId(@Param("employeeId") Long employeeId, String email);

    List<Employee> findByDepartment(Department department);

}

