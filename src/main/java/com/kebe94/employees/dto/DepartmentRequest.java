package com.kebe94.employees.dto;




import com.kebe94.employees.employee.Employee;
import lombok.Data;

import java.util.Collection;

@Data
public class DepartmentRequest {

    private Long departmentId;

    private String name;

    private String refDepart;

    private String emailManager;

    private String chiefDepart;

    private boolean enabled;

    private Collection<Employee> employees;



}
