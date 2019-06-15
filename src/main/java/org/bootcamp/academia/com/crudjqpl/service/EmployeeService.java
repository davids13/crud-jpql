package org.bootcamp.academia.com.crudjqpl.service;

import org.bootcamp.academia.com.crudjqpl.model.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    Employee save(Employee employee);

    void delete(Integer id);
}