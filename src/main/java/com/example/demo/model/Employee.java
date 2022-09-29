package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class Employee {
    @Id
    @SequenceGenerator(name = "employee_seq", sequenceName = "EMPLOYEE_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "employee_seq")
    private Integer id;
    private String username;

    public Employee() {
    }

    public Employee(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
