package com.severyn.zabara.springboot.springboot_rest.dao;




import com.severyn.zabara.springboot.springboot_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void deleteEmployee(int id);

    List<Employee> getAllEmployees();

    Employee getEmployee(int id);

    void saveEmployee(Employee employee);

}
