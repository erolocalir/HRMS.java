package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPosition;
import kodlama.io.hrms.entities.dtos.JobPositionWithAdvertisementDto;

@RestController
@RequestMapping("/api/Jobpositions")

public class JobPositionsControllers {
	
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsControllers(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	
	@GetMapping("/getall")
	public List<JobPosition> getAll(){
		return this.jobPositionService.getAll();
		
	}
	
	
	
	@GetMapping("/getbyname")
	public JobPosition getByPositionName(String positionName){
		return this.jobPositionService.getByPositionName(positionName);
	}
	
	
	@GetMapping("/getbyid")
	public DataResult<JobPosition> getById(int id){
		return this.jobPositionService.getById(id);
				
		
	}
	
	@PostMapping("add")
	public Result addNew(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.addNewPosition(jobPosition);
	}
	
	
	@GetMapping("/getJobPositionWithAdvertisementDetails")	
	public DataResult<List<JobPositionWithAdvertisementDto>> getJobPositionWithAdvertisementDetails(){
		return this.jobPositionService.getJobPositionWithAdvertisementDetails();
		
		
		
	}

	
}


