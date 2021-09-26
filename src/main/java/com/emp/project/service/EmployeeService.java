package com.emp.project.service;

import java.util.List;
import java.util.Optional;

import com.emp.project.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Optional<Employee> findById(Long employeeId);


	public Employee getByEmailIdAndPassword(String emailId, String password);

}
