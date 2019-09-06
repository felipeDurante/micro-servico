package com.br.app.controllers;

import com.br.app.services.EmployeeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeSearchController {

	@Autowired
	EmployeeSearchService employeeSearchService;

	@GetMapping("/employee/find/{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeSearchService.findById(id);
	}

	@GetMapping("/employee/findall")
	public Collection<Employee> findAll() {
		return employeeSearchService.findAll();
	}
}
