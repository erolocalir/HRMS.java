package kodlama.io.hrms.core.utilities.validation;

import kodlama.io.hrms.core.utilities.results.Result;

public interface EmailService {
	
	Result send(String title, String message, String string);

	

}
