package com.example.demoboot.EmployeeRepository;

import com.example.demoboot.model.Employee;
import com.sun.xml.bind.v2.model.core.EnumConstant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
