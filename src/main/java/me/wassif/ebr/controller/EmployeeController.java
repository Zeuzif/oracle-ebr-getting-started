package me.wassif.ebr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.wassif.ebr.dao.EmployeeRepository;
import me.wassif.ebr.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeRepository repository;
	
	@PostMapping
	public Long persist(@RequestBody Employee employee) {
		return repository.save(employee);
	}
}


