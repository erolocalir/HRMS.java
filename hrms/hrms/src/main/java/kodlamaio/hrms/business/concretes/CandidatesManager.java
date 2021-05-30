package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidatesService;
import kodlama.io.hrms.business.abstracts.UsersService;
import kodlama.io.hrms.core.utilities.MernisValidationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidatesDao;
import kodlama.io.hrms.entities.concretes.Candidates;
import kodlama.io.hrms.entities.concretes.verification.VerificationToCandidates;

@Service
public class CandidatesManager implements CandidatesService {

	
private CandidatesDao candidatesDao;
private UsersService usersService;
private MernisValidationService mernisValidationService;
	
    @Autowired
	public CandidatesManager(CandidatesDao candidatesDao, UsersService usersService,MernisValidationService mernisValidationService) {
	super();
	this.candidatesDao = candidatesDao;
	this.usersService = usersService;
	this.mernisValidationService = mernisValidationService;
}

	@Override
	public DataResult<List<Candidates>> getAll() {
		return new SuccessDataResult<List<Candidates>>(candidatesDao.findAll());
	}

	@Override
	public Result validation(VerificationToCandidates employee) {
		// TODO Auto-generated method stub
		return null;
	}


}


