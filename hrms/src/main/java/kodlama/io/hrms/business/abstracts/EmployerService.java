package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.verification.VerificationToEmployers;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	
	Result verification( VerificationToEmployers employer);
	
	DataResult<Employer> getById(Employer employer);

	DataResult<Employer> getById(int id);
	
	

	
}
