package kodlama.io.hrms.core.utilities.results;

import java.awt.Image;
import java.util.List;
import java.util.Optional;

public class SuccessDataResult<T> extends DataResult {
	
	public SuccessDataResult(T data) {
		super(data, true);
	}
	public SuccessDataResult(Optional<Image> optional, String message) {
		super(optional, true, message);
	}
	public SuccessDataResult(String message) {
		super(null, true, message);
	}

	public SuccessDataResult() {
		super(null, true);
	}

	
	

}


