package com.learning.EmployeeManagement.service;

import java.util.List;

import com.learning.EmployeeManagement.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public List<Employee> findAllbyName();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void deleteById(int theId);
}
