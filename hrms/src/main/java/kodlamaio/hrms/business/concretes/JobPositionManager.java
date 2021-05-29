package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;

public class JobPositionManager implements JobPositionService {

private JobPositionDao jobPositionDao;
	
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}



	@Override
	public List<JobPosition> getAll() {
		
		return this.jobPositionDao.findAll();
	}



	@Override
	public JobPosition getByPositionName(String positionName) {
		
		return this.jobPositionDao.findByPositonName(positionName);
	}



	@Override
	public Result addNewPosition(JobPosition jobPosition) {
		
		if(jobPosition.getPositionName() == null || jobPosition.getPositionName() == "")
			
			return new ErrorResult(" Pozisyon ismi boş bırakılamaz.");
		
		if(getByPositionName(((JobPosition) jobPosition).getPositionName()) != null)
			
			return new ErrorResult("Aynı isimde iki adet pozisyon olamaz.");
		
		this.jobPositionDao.save(jobPosition);
		
		return new SuccessResult("Pozisyon başarıyla eklendi.");
	}
}

