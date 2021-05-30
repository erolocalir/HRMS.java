package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Advertisement;

public interface AdvertisementService {
	
	DataResult<List<Advertisement>> findByIsActiveTrue();
	
	DataResult<List<Advertisement>> findByIsActiveTrueOrderByPublicationDate();
	
	DataResult<List<Advertisement>> findByEmployer_EmployerId(int employerid);
	
	Result addNewPosition(Advertisement advertisement);

	Result changeStatus(int advertisementId, int employerId);
	 
	
	
	

}

