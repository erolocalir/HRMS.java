package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidatesService;
import kodlama.io.hrms.business.abstracts.UsersService;
import kodlama.io.hrms.core.utilities.MernisValidationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidatesDao;
import kodlama.io.hrms.entities.concretes.Candidates;
import kodlama.io.hrms.entities.concretes.Users;
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
		
		if(runAllRules(employee) != null) return runAllRules(employee);
		
		if(!mernisValidationService.validate(employee.getIdentityNumber(), 
				
				employee.getFirstName(), 
				
				employee.getLastName(), 	
				
				0, employee.getDateOfBirth()).isSuccess()) {
			
			
			
			
			
				return new ErrorResult("TC Kimlik Numarası doğrulaması başarısız.");
				
				
			}
			Users verifications = new Users(employee.getEmail(), employee.getPassword(),false, UUID.randomUUID().toString());
			
			usersService.add(verifications);
			
			Candidates verificationToCandidates  = new Candidates(verifications.getId(), 
					
					employee.getFirstName(),
					
					employee.getLastName(), 
					
					employee.getIdentityNumber(),
					
					employee.getDateOfBirth(), verifications);
			
			this.candidatesDao.saveAll(verifications);
			
			
			return new SuccessResult("Kayıt başarılı. e-posta adresinize gönderilen doğrulama linkiyle hesabınızı doğrulayabilirsiniz.");
		}
		
		
	
	

	private Result runAllRules(VerificationToCandidates employee) {
		
		if(isAllFieldsFilled(employee) != null) return isAllFieldsFilled(employee);
		
		if(isPasswordsMatch(employee) != null) return isPasswordsMatch(employee);
		
		if(isUserExistWithEmail(employee) != null) return isUserExistWithEmail(employee);
		
		if(isUserExistWithNationalityId(employee) != null) return isUserExistWithNationalityId(employee);
		
		return null;
		
	}

	private Result isUserExistWithNationalityId(VerificationToCandidates employee) {
		
		if(candidatesDao.findByNationalityId(employee.getIdentityNumber()) != null)
			
			return new ErrorResult("Bu TC kimlik ile başka bir kullanıcı mevcut.");
		
		return null;
		
	}

	private Result isUserExistWithEmail(VerificationToCandidates employee) {
	
		if(usersService.getByEmail(employee.getEmail()).getData() != null)
			
			return new ErrorResult("Bu e-posta adresiyle başka bir kullanıcı zaten mevcut.");
		
		return null;
		
		
	}

	private Result isPasswordsMatch(VerificationToCandidates employee) {
	
		if(!employee.getPassword().equals(employee.getPassword())) {
			
			return new ErrorResult("Şifreleriniz uyuşmuyor.");
		
		}
		return null;
		
		
		
	}

	private Result isAllFieldsFilled(VerificationToCandidates employee) {
		
		if(   employee.getPassword() == null || employee.getPassword().equals("") 
				
				  ||  employee.getPassword() == null  || employee.getPassword().equals("")
				  
				  ||  employee.getEmail() == null || employee.getEmail().equals("")
				  
				  ||  employee.getIdentityNumber() == null ||  employee.getIdentityNumber().equals("")
				  
				  ||  employee.getLastName() == null || employee.getLastName().equals("")
				  
				  ||  employee.getFirstName() == null || employee.getFirstName().equals("")
				  
				  ||  employee.getDateOfBirth() == null)
			
					return new ErrorResult("Tüm alanları doldurulmalı.");
		
				return null;
		
	}


	
}








































