package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Users;
import kodlama.io.hrms.entities.concretes.verification.Verifications;

public interface UsersDao extends JpaRepository<Users, Integer>{
	
	Users getEmail(String email);
	
	Verifications getactivaitonCode(int activationCode);

	Users findByEmail(String email);

	Users findByEmailAndEmailVerifyCode(String email, String activationCode);
	
	
	
	
	
	

}


