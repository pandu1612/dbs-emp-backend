package com.emp.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.project.entity.Employee;
import com.emp.project.exception.ResourceNotFoundException;
import com.emp.project.repository.EmployeeRepository;
import com.emp.project.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository emprepo;

	public List<Employee> findAll() {
		List<Employee> dblist = emprepo.findAll();

		System.out.println("before sort");
		dblist.forEach((emp) -> System.out.println(emp.getName()));

		dblist.sort((Employee emp1, Employee emp2) -> emp1.getName().compareTo(emp2.getName()));

		System.out.println("After Sorting ");
		dblist.forEach((emp) -> System.out.println(emp.getName()));

		return emprepo.findAll();
	}

	@Override
	public Optional<Employee> findById(Long employeeId) {
		// TODO Auto-generated method stub
		return emprepo.findById(employeeId);
	}

	@Override
	public Employee getByEmailIdAndPassword(String emailId, String password) {
		// TODO Auto-generated method stub
		Employee emp = emprepo.getByEmailIdAndPassword(emailId, password);
		return emp;
	}

}
