package com.learning.EmployeeManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.EmployeeManagement.entity.Employee;
import com.learning.EmployeeManagement.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	User findByUsername(String username);

	User findById(int theId);

	User save(User theUser);

	void deleteById(int theId);

}
