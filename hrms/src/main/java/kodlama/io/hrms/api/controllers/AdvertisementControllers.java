package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.AdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Advertisement;

@RestController
@RequestMapping("/api/advertisements")

public class AdvertisementControllers {

	private AdvertisementService advertisementService;
	
    @Autowired
	public AdvertisementControllers(AdvertisementService advertisementService) {
		super();
		this.advertisementService = advertisementService;
	}
	
    @GetMapping("/getAllActive")
    public DataResult<List<Advertisement>> getAllActive(){
	return this.advertisementService.findByIsActiveTrue();
	
    }
	
	@GetMapping("/getAllActiveOrderByDate")
	public DataResult<List<Advertisement>> getAllActiveOrderDate(){
	return this.advertisementService.findByIsActiveTrueOrderByPublicationDate();
	
	}
	
	
	@GetMapping("/getAllActiveByEmployer")
	public DataResult<List<Advertisement>> getAllActiveOrderDate(int employerId){
	return this.advertisementService.findByEmployer_EmployerId(employerId);
	
	}
		
		
	@PostMapping("/add")	
	public Result addNewPosition(@RequestBody Advertisement advertisement) {
    return this.advertisementService.addNewPosition(advertisement);	
}


	}
	
