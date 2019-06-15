package org.bootcamp.academia.com.crudjqpl.service;

import org.bootcamp.academia.com.crudjqpl.dao.EmployeeDAO;
import org.bootcamp.academia.com.crudjqpl.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Integer id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        employeeDAO.save(employee);
        return employee;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        employeeDAO.delete(id);
    }
}