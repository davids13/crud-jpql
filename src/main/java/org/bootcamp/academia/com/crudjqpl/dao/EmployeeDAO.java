package org.bootcamp.academia.com.crudjqpl.dao;

import org.bootcamp.academia.com.crudjqpl.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    void save(Employee employee);

    void delete(Integer id);
}