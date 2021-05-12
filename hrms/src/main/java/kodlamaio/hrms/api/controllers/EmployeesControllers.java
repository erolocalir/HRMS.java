package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employeeusers")
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
