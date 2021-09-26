package com.emp.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emp.project.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "select * from User where email_address = :emailId and password = :password", nativeQuery = true)
	Employee getByEmailIdAndPassword(@Param("emailId") String emailId, @Param("password") String password);

}