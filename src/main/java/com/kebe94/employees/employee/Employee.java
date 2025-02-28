package com.kebe94.employees.employee;


import com.fasterxml.jackson.annotation.JsonProperty;

import com.kebe94.employees.department.Department;
import com.kebe94.employees.entity.AbstractEntity;
import com.kebe94.employees.enums.Genre;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long employeeId;

    private String firstName;
    private String lastName;
    private Integer telephone;
    private String email;
    private String refDepart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiringDate;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Department department;



}
