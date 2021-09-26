package com.emp.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import com.emp.project.entity.Employee;
import com.emp.project.exception.ResourceNotFoundException;
import com.emp.project.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
//    @Autowired
//    private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
		Optional<Employee> employee = employeeService.findById(employeeId);
		return ResponseEntity.ok().body(employee);
	}

	//
	@PostMapping("/employees/login")
	public ResponseEntity<Object> validateEmployeeLogin(@RequestBody Employee employee)
			throws ResourceNotFoundException {
		String emailId = employee.getEmailId();
		String password = employee.getPassword();
		Employee emp = employeeService.getByEmailIdAndPassword(emailId, password);
		if (emp == null)
			throw new ResourceNotFoundException("no Employee found for given EmailId/Password");

		return ResponseEntity.ok(emp);
	}
//
//
//    @PostMapping("/employees")
//    public Employee createEmployee(@Valid @RequestBody Employee employee) {
//        return employeeRepository.save(employee);
//    }
//
//    @PutMapping("/employees/{id}")
//    public ResponseEntity < Employee > updateEmployee(@PathVariable(value = "id") Long employeeId,
//        @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
//        Employee employee = employeeRepository.findById(employeeId)
//            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        employee.setEmailId(employeeDetails.getEmailId());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setFirstName(employeeDetails.getFirstName());
//        final Employee updatedEmployee = employeeRepository.save(employee);
//        return ResponseEntity.ok(updatedEmployee);
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long employeeId)
//    throws ResourceNotFoundException {
//        Employee employee = employeeRepository.findById(employeeId)
//            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        employeeRepository.delete(employee);
//        Map < String, Boolean > response = new HashMap < > ();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
}