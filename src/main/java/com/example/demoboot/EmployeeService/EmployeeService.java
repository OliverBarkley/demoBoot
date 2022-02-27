package com.example.demoboot.EmployeeService;

import com.example.demoboot.EmployeeRepository.EmployeeRepository;
import com.example.demoboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    public void editEmployee(Employee employee) {
        employeeRepository.saveAndFlush(employee);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.getById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
