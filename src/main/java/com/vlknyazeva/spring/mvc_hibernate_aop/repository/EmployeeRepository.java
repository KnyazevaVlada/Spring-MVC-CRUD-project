package com.vlknyazeva.spring.mvc_hibernate_aop.repository;

import com.vlknyazeva.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    void deleteEmployee(int id);
}
