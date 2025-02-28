package com.kebe94.employees.department.service;



import com.kebe94.employees.department.Department;
import com.kebe94.employees.department.DepartmentRepository;
import com.kebe94.employees.divers.Generate;
import com.kebe94.employees.employee.Employee;
import com.kebe94.employees.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department departmentRequest) {
        departmentRequest.setRefDepart(Generate.CodeGenerate("DP",7));
        return departmentRepository.save(departmentRequest);
    }

    @Override
    public Department getDepartment(Long departmentId) {
        try {
          Department department = departmentRepository.findById(departmentId).get();
            return department;
        } catch (Exception e) {
            throw new ResourceNotFoundException("erreur 404 page introuvable");
        }


    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteDepartment(Long departmentId) {
        Optional<Department> existingDepartment = departmentRepository.findById(departmentId);

            if (existingDepartment.isPresent()) {
                if (!existingDepartment.get().getEmployees().isEmpty()) {
                    throw new ResourceNotFoundException("impossible de supprimer un departement qui a deja des employés");
                }
                departmentRepository.deleteById(existingDepartment.get().getDepartmentId());
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        }


}
