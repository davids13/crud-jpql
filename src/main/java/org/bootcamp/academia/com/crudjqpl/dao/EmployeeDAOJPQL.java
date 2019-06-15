package org.bootcamp.academia.com.crudjqpl.dao;

import org.bootcamp.academia.com.crudjqpl.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository //that marks the specific class as a Data Access Object, thus clarifying it's role
public class EmployeeDAOJPQL implements EmployeeDAO {

    //JPQL - oriented programming query language for performing queries
        //it is similar to SQL, but queries the entity model instead of tables and supports
        //OOP notions like inheritance and polymorphism
    /*
    Criteria Queries
        JPQL is a non type-safe way to perform query operations
        Criteria queries are a programmatic and type-safe
           way to express a query

        With JPQL queries are constructed using a string based approach
        With Criteria, queries are constructed with query definition objects
        With Criteria, the Java compiler will check for query correctness and reduce run-time errors
        Criteria allows building dynamic queries without performing string concatenation
        Constructing and running queries dynamically with JPQL requires String concatenation,
        which can result in security holes
     */

    private EntityManager entityManager;

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
        //Employee is the entity being queried, employee is an identification variable
        //used in all other parts of the query to reference this entity
        try {
            TypedQuery<Employee> query = entityManager.createQuery("SELECT employee FROM Employee employee", Employee.class);
            return query.getResultList();
        }
        finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public Employee getEmployeeById(Integer id) {

        try {
            TypedQuery<Employee> query = entityManager.createQuery("SELECT employee FROM Employee employee WHERE employee.id = :idToSearch", Employee.class);
            query.setParameter("idToSearch", id);
            return query.getSingleResult();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void save(Employee employee) {

        //save or update the employee
        Employee employeeDB = entityManager.merge(employee);

        //update with id from db
        employee.setId(employeeDB.getId());
    }

    @Override
    public void delete(Integer id) {

        try {
            Query query = entityManager.createQuery("DELETE FROM Employee employee WHERE employee.id=:idToDelete");
            query.setParameter("idToDelete", id);
            query.executeUpdate();
        }
        finally {
            if(entityManager != null) {
                entityManager.close();
            }
        }
    }

}