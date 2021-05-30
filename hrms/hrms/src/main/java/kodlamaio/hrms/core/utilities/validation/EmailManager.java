package kodlama.io.hrms.core.utilities.validation;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;

public class EmailManager implements EmailService{

	@Override
	public Result send(String title, String message, String string) {
		return new SuccessResult("Doğrulama E-postası gönderildi");
	}

	
	

}
