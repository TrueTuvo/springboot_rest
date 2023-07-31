package com.severyn.zabara.springboot.springboot_rest.dao;

import com.severyn.zabara.springboot.springboot_rest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();
        Query query = entityManager.createQuery("delete from Employee where id =: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

    @Override
    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//        List<Employee> employees = session.createQuery("from Employee",
//                        Employee.class)
//                .getResultList();
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
        Employee merge = entityManager.merge(employee);
        employee.setId(merge.getId());
    }


}
