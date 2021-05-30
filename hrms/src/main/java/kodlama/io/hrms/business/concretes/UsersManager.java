package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlama.io.hrms.business.abstracts.UsersService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.utilities.validation.EmailService;
import kodlama.io.hrms.dataAccess.abstracts.UsersDao;
import kodlama.io.hrms.entities.concretes.Users;

public class UsersManager implements UsersService {
	
   private UsersDao usersDao;
   private EmailService emailService;
	

    @Autowired
    public UsersManager(UsersDao usersDao, EmailService emailService) {
	super();
	this.usersDao = usersDao;
	this.emailService = emailService;
	
}


    
	@Override
	public DataResult<List<Users>> getAll() {
		
		return new SuccessDataResult<List<Users>>( usersDao.findAll() );
	}




	@Override
	public DataResult<Users> getByEmail(String email) {
		return new SuccessDataResult<Users>(usersDao.findByEmail(email));
	
	}


	
	@Override
	public Result add(Users users) {
		
		
			this.usersDao.save(users);
			this.emailService.send(users.getEmail(), 
					"Doğrulama Linki", 
					"Hoşgeldiniz."
					+ "Aşağıdaki linke tıklayarak üyeliğinizi doğrulayabilirsiniz. "
					+ "www.localhost:8080/api/users/verify?email=" + users.getEmail() + "&verifycode=" + users.isEmailVerified());
			        return new SuccessResult();
		}
	
	
	
	
	
	

	@Override
	public Result verifyUser(String email, String activationCode) {
		
		Users users = usersDao.findByEmailAndEmailVerifyCode(email,activationCode);
		if(users == null)
			return new ErrorResult("Bir hata oluştu lütfen bilgileri doğru girdiğinizden emin olun.");
		
		users.setEmailVerified(true);
		usersDao.save(users);
		return new SuccessResult("Kullanıcı e-postası başarıyla doğrulandı.");
	}
		
		
	
	


	}
	
	


