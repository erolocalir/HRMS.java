package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidates;
import kodlama.io.hrms.entities.concretes.verification.EmployerVerificationByEmployees;
import kodlama.io.hrms.entities.concretes.verification.VerificationToCandidates;

public interface CandidatesService {
	
	DataResult<List<Candidates>> getAll();
	Result validation(VerificationToCandidates employee);

}

