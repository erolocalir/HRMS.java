package kodlama.io.hrms.core.utilities;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;

@Service
public class MernisServisAdapter implements MernisValidationService {

	
	@Override
	public Result validate(String identityNumber, String firstName, String lastName, int dateOfBirth, String string) {
		return new SuccessResult("Kimlik doğrulaması başarılı.");
	}
	
	
	
	

}
