package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.UsersService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Users;

@RestController
@RequestMapping("/api/Users")

public class UsersControllers {
	
private UsersService usersService;
	
	
    @Autowired
	public UsersControllers(UsersService usersService) {
		super();
		this.usersService = usersService;
	}
	

    @GetMapping("/getall")
    public DataResult<List<Users>> getAll(){
    	return usersService.getAll();
    	
    }
    
    @PostMapping("/verify")
    public Result verify(String email, String activationCode) {
    	return usersService.verifyUser(email, activationCode);
    	
    	
    }
    
    

}

