package com.kebe94.employees.web;




import com.kebe94.employees.department.Department;
import com.kebe94.employees.department.service.DepartmentService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/departments")
@RestController
@AllArgsConstructor
public class DepartmentController {
	private final DepartmentService departmentService;


    @PostMapping(path = "")
    public Department saveDepartment(@RequestBody Department departmentRequest){
        return    departmentService.saveDepartment(departmentRequest);
    }

    @PatchMapping(path = "")
    public Department updateDepartment(@RequestBody Department departmentRequest){
        return    departmentService.saveDepartment(departmentRequest);
    }
    @GetMapping(path = "/{departmentId}")
    public Department getDepartment(@PathVariable(name = "departmentId") Long departmentId){
        return    departmentService.getDepartment(departmentId);
    }

    @GetMapping(path = "")
    public List<Department> detAllDepartment(){
        return    departmentService.getAllDepartment();
    }


    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable(name = "departmentId") Long departmentId){
        return    departmentService.deleteDepartment(departmentId);
    }

}
