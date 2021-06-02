package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;
import kodlama.io.hrms.entities.dtos.JobPositionWithAdvertisementDto;

@Service
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
			
			return new ErrorResult(" Bu alan boş bırakılamaz.");
		
		if(getByPositionName(((JobPosition) jobPosition).getPositionName()) != null)
			
			return new ErrorResult("Bu isimde bir pozisyon zaten mevcut.");
		
		this.jobPositionDao.save(jobPosition);
		
		return new SuccessResult("Yeni pozisyon başarıyla eklendi.");
	}


	


	@Override
	public DataResult<JobPosition> getById(int id) {
		
		JobPosition jobPosition = jobPositionDao.findById(id);
		
		if(jobPosition==null) return new ErrorDataResult<JobPosition>();
		
	    return new SuccessDataResult<JobPosition>(jobPosition);
	    
		
	}



	@Override
	public DataResult<JobPosition> getById(JobPosition jobPosition) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public DataResult<List<JobPositionWithAdvertisementDto>> getJobPositionWithAdvertisementDetails() {
		
		return new SuccessDataResult<List<JobPositionWithAdvertisementDto>>
		
		(this.jobPositionDao.getJobPositionWithAdvertisementDetails(),"Detaylar getirildi");
		
		
	}
}












