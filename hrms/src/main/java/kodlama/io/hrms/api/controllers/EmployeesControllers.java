package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EmployeeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/Employees")

public class EmployeesControllers {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeesControllers(EmployeeService systemUserService) {
		super();
		this.employeeService = systemUserService;
	}
	
	@GetMapping("/getall")
	public List<Employee> getAll(){
		return employeeService.getAll();
		
		
		
	}

	
}
