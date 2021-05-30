package kodlama.io.hrms.core.utilities;

import kodlama.io.hrms.core.utilities.results.Result;

public interface MernisValidationService {
	
	Result validate(String identityNumber, String firstName, String lastName,int dateOfBirth, String string);

	//Result validate(String identityNumber, String firstName, String lastName, int dateOfBirth);

}



