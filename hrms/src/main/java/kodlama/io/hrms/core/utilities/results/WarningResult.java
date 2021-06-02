package kodlama.io.hrms.core.utilities.results;

public class WarningResult extends Result {

	public WarningResult(boolean success) {
		super(success);
			
	}
	
	public WarningResult(String message) {
		super(true, message);
		
	}

}
