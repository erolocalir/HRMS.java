package kodlama.io.hrms.business.concretes;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.AdvertisementService;
import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.business.BusinessRules;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.AdvertisementDao;
import kodlama.io.hrms.entities.concretes.Advertisement;
import kodlama.io.hrms.entities.concretes.City;
import kodlama.io.hrms.entities.concretes.JobPosition;

@Service
public class AdvertisementManager implements AdvertisementService{
	
	
	private AdvertisementDao advertisementDao;
	
	private EmployerService employerService;
	
	private JobPositionService jobPositionService;
	
	private CityService cityService;

	
    @Autowired
	public AdvertisementManager(AdvertisementDao advertisementDao, EmployerService employerService,
			JobPositionService jobPositionService, CityService cityService) {
		super();
		this.advertisementDao = advertisementDao;
		this.employerService = employerService;
		this.jobPositionService = jobPositionService;
		this.cityService = cityService;
	}
	
	
	
	
	
	@Override
	public DataResult<List<Advertisement>> findByIsActiveTrue() {
		
		return new SuccessDataResult<List<Advertisement>>(advertisementDao.findByIsActiveTrue());
		
	}
	
	
	
	@Override
	public DataResult<List<Advertisement>> findByIsActiveTrueOrderByPublicationDate() {
		
		return new SuccessDataResult<List<Advertisement>>(advertisementDao.findByIsActiveTrueOrderByPublicationDate());
		
		
		
	}

	
	
	
	@Override
	public DataResult<List<Advertisement>> findByEmployer_EmployerId(int employerid) {
	
		return new SuccessDataResult<List<Advertisement>>(advertisementDao.findByIsActiveTrueAndEmployer_userid(employerid));
		
		
	}

	
	
	
	@Override
	public Result addNewPosition(Advertisement advertisement) {
		
		
		Result businessRulesResult = BusinessRules.run( 
				
				isJobPositionValid(advertisement.getJobPosition()),
				
				isJobDescriptionValid(advertisement.getDescription()),
				
				isCityValid(advertisement.getCity()),
				
				isOpenPositionValid(advertisement.getOpenPositions()),
				
				isEndDateValid(advertisement.getLastApplicaitonData())
				
				);
		
		if ( businessRulesResult != null ) return businessRulesResult;
		
		
		
		if(!employerService.getById(advertisement.getEmployer()).isSuccess()) {
			
			return new ErrorResult("B??yle bir firma yok.");
		}
		
		
		
		
		Advertisement advertisementToAdd = new Advertisement();
		
		advertisementToAdd.setCity(cityService.getById(advertisement.getCity()).getData());
		
		advertisementToAdd.setJobPosition(jobPositionService.getById(advertisement.getJobPosition()).getData());
		
		advertisementToAdd.setEmployer(employerService.getById(advertisement.getEmployer()).getData());
		
		advertisementDao.save(advertisementToAdd);
		
		return new SuccessResult("???? ilan?? ba??ar?? ile olu??turuldu.");
	}
	


	private Result isJobDescriptionValid(String description) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	
	public Result changeStatus(int advertisementId, int employerId) {
		
	Advertisement jobAdvertisementToUpdate = advertisementDao.findByIdAndEmployer_Userid(advertisementId, employerId);
		
		if(jobAdvertisementToUpdate==null) return new ErrorResult("Bu kriterlere uyan bir i?? ilan?? bulamad??.");
		
		jobAdvertisementToUpdate.setActive(!jobAdvertisementToUpdate.isActive());
		
		advertisementDao.save(jobAdvertisementToUpdate);
		
		return new SuccessResult("Belirtilen i?? ilan?? " + (jobAdvertisementToUpdate.isActive() ? "aktif" : "pasif") + " hale getirildi.");
	}
	
	private Result isJobPositionValid(JobPosition jobPosition) {
		
		if(jobPosition==null) return new ErrorResult("???? pozisyonu do??ru de??il.");
		
		if(jobPositionService.getById(jobPosition).getData() == null) return new ErrorResult("B??yle bir pozisyon yok.");
		
		return new SuccessResult();
	}
	private Result isJobDescValid(String jobDesc) {
		
		if(jobDesc == null || jobDesc.equals("")) return new ErrorResult("A????klama do??ru girilmedi");
		
		return new SuccessResult();
	}
	private Result isCityValid(City city) {
		
		if(city==null) return new ErrorResult("??ehir do??ru girilmedi");
		
		if(cityService.getById(city).getData() == null) return new ErrorResult("B??yle bir ??ehir yok.");
		
		return new SuccessResult();
	}
	private Result isOpenPositionValid(int count) {
		
		if(count<=0) return new ErrorResult("A????k i?? pozisyonu 0 ve 0'dan b??y??k olmal??d??r.");
		
		return new SuccessResult();
	}
	private Result isEndDateValid(Date endDate) {

		if(new Date().compareTo(endDate) > 0) {
			
			return new ErrorResult("Son ba??vuru tarihi i?? ilan?? tarihinden ??nce olamaz.");
		}
		
		return new SuccessResult();
	}

		
		
		
	}



























