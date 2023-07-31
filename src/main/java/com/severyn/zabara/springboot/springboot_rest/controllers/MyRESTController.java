package com.severyn.zabara.springboot.springboot_rest.controllers;

import com.severyn.zabara.springboot.springboot_rest.entity.Employee;
import com.severyn.zabara.springboot.springboot_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService service;

    @RequestMapping("/employees")
    public List<Employee> showAllEmployees() {

        List<Employee> employees = service.getAllEmployees();

        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = service.getEmployee(id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return employee;
    }

    @PutMapping ("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Employee employee = service.getEmployee(id);
        service.deleteEmployee(id);
        return "Employee with id: " + id + " has been deleted";
    }
}