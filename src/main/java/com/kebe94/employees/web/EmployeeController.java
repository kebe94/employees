package com.kebe94.employees.web;




import com.kebe94.employees.dto.EmployeeResponsePages;
import com.kebe94.employees.employee.Employee;
import com.kebe94.employees.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/employees")
@CrossOrigin("*")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping(path = "")
    public Employee saveEmployee(@RequestBody Employee employee){
        return    employeeService.saveEmployee(employee);
    }

    @PatchMapping(path = "")
    public Employee updateEmployee(@RequestBody Employee employee){
        return    employeeService.saveEmployee(employee);
    }

    @GetMapping(path = "/{employeeId}")
    public Employee getEmployee(@PathVariable(name = "employeeId") Long employeeId){

        return    employeeService.getEmployee(employeeId);
    }


    @GetMapping(path = "")
    public List<Employee> detAllEmployee(){
        return    employeeService.getAllEmployee();
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "employeeId") Long employeeId){
        return    employeeService.deleteEmployee(employeeId);
    }

    @GetMapping(path = "search")
    public EmployeeResponsePages searchEmployeeLastName(
            @RequestParam(name="mc", defaultValue="")String mc,
            @RequestParam(name="page", defaultValue="0")int page,
            @RequestParam(name="size",defaultValue="7")int size){
        return  employeeService.searchEmployeeLastName("%"+mc+"%", page, size);

    }


}
