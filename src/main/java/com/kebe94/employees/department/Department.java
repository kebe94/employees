package com.kebe94.employees.department;

import com.fasterxml.jackson.annotation.JsonProperty;


import com.kebe94.employees.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Department {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long departmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "ref_depart")
    private String refDepart;

    @Column(name = "email_manager")
    private String emailManager;

    @Column(name = "chief_depart")
    private String chiefDepart;

    private boolean enabled;

    @OneToMany(mappedBy = "department")
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Employee> employees;


}
