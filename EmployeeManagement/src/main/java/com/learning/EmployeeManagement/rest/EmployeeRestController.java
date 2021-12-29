package com.learning.EmployeeManagement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QSort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.EmployeeManagement.entity.Employee;
import com.learning.EmployeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theEmpService) {
		employeeService = theEmpService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/sort?order=”asc”")
	public List<Employee> findAllasc(QSort asc) {
		return employeeService.findAllbyName();
	}

	@GetMapping("/employees/sort?order=”desc”")
	public List<Employee> findAlldesc(QSort desc) {
		return employeeService.findAllbyName();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if (theEmployee == null) {
			throw new RuntimeException("Employee ID is invalid");
		}
		return theEmployee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}

	@PutMapping("/employee/{employeeId}")
	public Employee deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmp = employeeService.findById(employeeId);
		if (tempEmp == null) {
			throw new RuntimeException("Employee cannot found!");
		}
		employeeService.deleteById(employeeId);
		return tempEmp;
	}

}
