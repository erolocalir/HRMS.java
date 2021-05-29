package kodlama.io.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.UsersService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.Users;
import kodlama.io.hrms.entities.concretes.verification.VerificationToEmployers;

@Service
public class EmployerManager implements EmployerService{
	
private EmployerDao employerDao;
private UsersService userService;


    @Autowired
	public EmployerManager(EmployerDao employerDao, UsersService userService) {
	super();
	this.employerDao = employerDao;
	this.userService = userService;
}


	@Override
	public DataResult<List<Employer>> getAll() {
		
       return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
       
	}


	@Override
	public Result verification(VerificationToEmployers employer) {
		
		return null;
	}


	
}






























