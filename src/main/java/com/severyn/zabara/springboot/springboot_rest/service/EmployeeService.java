package com.severyn.zabara.springboot.springboot_rest.service;





import com.severyn.zabara.springboot.springboot_rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

     List<Employee> getAllEmployees();

     void saveEmployee(Employee employee);

     void deleteEmployee(int id);

    Employee getEmployee(int id);

}
