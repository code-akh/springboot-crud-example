package com.crudexample.springboot.service;

import com.crudexample.springboot.model.Employee;

import java.util.List;

public interface EmployeeService{

    Employee saveEmployee(Employee emp);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    Employee updateEmployee(Employee emp, long id);

    void deleteEmployee(long id);
}
