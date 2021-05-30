package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	List<JobPosition> getAll();
	JobPosition getByPositionName(String positionName);
    Result addNewPosition(JobPosition jobPosition);
    
	}





