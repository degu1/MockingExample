package com.example;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class TestEmployeeRepository implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {
        Employee employee = new Employee("1",1000);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        return employees;
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
