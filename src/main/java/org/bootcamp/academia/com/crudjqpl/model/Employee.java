package org.bootcamp.academia.com.crudjqpl.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

    //define fields
    //define annotations
    //define no args-constructor
    //define constructor
    //define getter setter
    //define toString

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    @NotNull(message = "Required")
    @NotBlank(message = "Required")
    @Size(min = 2, max = 50)
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Required")
    @NotBlank(message = "Required")
    @Size(min = 2, max = 50)
    private String lastName;

    @Column
    @Email
    @NotNull(message = "Required")
    @NotBlank(message = "Required")
    private String email;

    public Employee() {
    }

    public Employee(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}