package com.learning.EmployeeManagement.dao;

import java.util.List;

import com.learning.EmployeeManagement.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void deleteById(int theId);

}
