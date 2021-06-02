package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPosition;
import kodlama.io.hrms.entities.dtos.JobPositionWithAdvertisementDto;

public interface JobPositionService {
	
	List<JobPosition> getAll();
	
	JobPosition getByPositionName(String positionName);
	
    Result addNewPosition(JobPosition jobPosition);
    
    DataResult<JobPosition> getById(JobPosition jobPosition);

	DataResult<JobPosition> getById(int id);
	
	DataResult<List<JobPositionWithAdvertisementDto>> getJobPositionWithAdvertisementDetails();
    
	}









