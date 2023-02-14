package me.wassif.ebr.dao;

import me.wassif.ebr.model.Employee;


public interface EmployeeRepository {
	public Long save(Employee employee);
}
