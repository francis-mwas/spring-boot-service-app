package com.fram.Springbootdemo.service;

import com.fram.Springbootdemo.errors.EmployeeNotFoundException;
import com.fram.Springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    List<Employee> employeeList = new ArrayList<Employee>();


    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeList
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
                .orElseThrow(()-> new EmployeeNotFoundException(""+ "Employee with id: "
                                                            + id + " does not exist"));
    }

    @Override
    public String deleteEmployeeById(String id) {

        Employee employee = employeeList.stream().filter(e->
                e.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .get();
        employeeList.remove(employee);

        return "Employee with id: "+ id +" has been deleted from the database";
    }

}
