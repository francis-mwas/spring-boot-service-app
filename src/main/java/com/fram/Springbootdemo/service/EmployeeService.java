package com.fram.Springbootdemo.service;

import com.fram.Springbootdemo.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> getEmployees();

    Employee getEmployeeById(String id);


    String deleteEmployeeById(String id);
}
