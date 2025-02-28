package com.kebe94.employees.department;

import com.kebe94.employees.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>, JpaSpecificationExecutor<Department> {


   @Query("SELECT d FROM Department d WHERE d.departmentId =:departmentId")
    List<Employee> findAllByDepartment(Long departmentId);

}
