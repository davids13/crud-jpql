package org.bootcamp.academia.com.crudjqpl.restController;

import org.bootcamp.academia.com.crudjqpl.model.Employee;
import org.bootcamp.academia.com.crudjqpl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/jpql")
public class RestController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<Employee>> listEmployees() {

        List employees = new ArrayList<>();
        for(Employee employee : employeeService.getAllEmployees()){
            employees.add(employee);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {

        Employee employee = employeeService.getEmployeeById(id);
        if(employee.getId() == null) {
          return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"/{id}"})
    public ResponseEntity deleteEmployee(@PathVariable Integer id){

        employeeService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = {"/{id}"})
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult, @PathVariable Integer id) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(employeeService.getEmployeeById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        employee.setId(id);
        employeeService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/",""})
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Employee addedEmployee = employeeService.save(employee);
        return new ResponseEntity<>(addedEmployee, HttpStatus.CREATED);
    }
}