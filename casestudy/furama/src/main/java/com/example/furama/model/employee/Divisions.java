package com.example.furama.model.employee;

import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Divisions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer divisionId;
    @Column(unique = true,nullable = false,length = 45)
    private String divisionName;

    @OneToMany(mappedBy = "divisions")
    private Set<Employee> employees;

    public Divisions() {
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employee) {
        this.employees = employee;
    }
}
