package kodlama.io.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.UsersService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
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


	
	@Override
	public DataResult<Employer> getById(int id) {
		
		Employer employer = employerDao.getById(id);
		
		if(employer==null) return new ErrorDataResult<Employer>();
		
		return new SuccessDataResult<Employer>(employer);
		
	}
	
   private Result runAllVerification(VerificationToEmployers employers) {
	   
	if(isAllFieldsFilled(employers) != null) return isAllFieldsFilled(employers);
	   
	if(isPasswordSame(employers) != null) return isPasswordSame(employers);
		
	if(isEmailandWebsiteDomainSame(employers) != null) return isEmailandWebsiteDomainSame(employers);
		
	if(isEmailAlreadyUse(employers) != null) return isEmailAlreadyUse(employers);
	return null;
		
	   
	


	
}


   private Result isEmailAlreadyUse(VerificationToEmployers employers) {
	
	   if(userService.getByEmail(employers.getEmail()).getData() != null) return new ErrorResult("Bu e-posta adresiyle kayıtlı bir kullanıcı var.");
	   
		return null;
	
	
	
		
	
}
   


private Result isEmailandWebsiteDomainSame(VerificationToEmployers employers) {
	
	String email = employers.getEmail();
	
	String[] emailSplit = email.split("@");
	
	if(!emailSplit[1].equals(employers.getWebAddress())) return new ErrorResult("E-posta adresinizin domaini web siteniz ile aynı değil.");
	
	return null;
	
	
}


private Result isPasswordSame(VerificationToEmployers employers) {
	
	if(!employers.getPassword().equals(employers.getPassword())) return new ErrorResult("Şifreleriniz uyuşmuyor.");
	
	return null;
	
}


private Result isAllFieldsFilled(VerificationToEmployers employers) {
	
	 if(employers.getCompanyName() == null || employers.getPhoneNumber() == null || employers.getWebAddress() == null || employers.getEmail() == null ||
			   
			   employers.getPassword() == null || employers.getPassword() == null) return new ErrorResult("Lütfen tüm alanları doldurduğunuzdan emin olun.");
	   
	if(employers.getCompanyName().equals("") || employers.getPhoneNumber().equals("") || employers.getWebAddress().equals("") || employers.getEmail().equals("") ||
			
			   employers.getPassword().equals("") || employers.getPassword().equals("")) return new ErrorResult("Lütfen tüm alanları doldurduğunuzdan emin olun.");
	
	return null;
	
}


@Override
public DataResult<Employer> getById(Employer employer) {
	// TODO Auto-generated method stub
	return null;
}














}













































































