package com.vlknyazeva.spring.mvc_hibernate_aop.service;

import com.vlknyazeva.spring.mvc_hibernate_aop.repository.EmployeeRepository;
import com.vlknyazeva.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// данный класс связует controller и DAO, поэтому мы всю бизнесс-логику прописываем через него
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional     //spring берет на себя ответственность за открытие/зкрытие транзакций
    public List<Employee> getAllEmployees() {

        return employeeRepository.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {

        employeeRepository.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {

        return employeeRepository.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {

        employeeRepository.deleteEmployee(id);
    }
}
