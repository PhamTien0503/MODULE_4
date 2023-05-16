package com.example.furama.service.employee.impl;

import com.example.furama.model.employee.Employee;
import com.example.furama.repository.employee.IEmployeeRepository;
import com.example.furama.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
