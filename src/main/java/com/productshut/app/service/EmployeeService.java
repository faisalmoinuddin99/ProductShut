package com.productshut.app.service;


import com.productshut.app.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee addEmployee(Employee employee) ;

    public List<Employee> getEmployee() ;
}
