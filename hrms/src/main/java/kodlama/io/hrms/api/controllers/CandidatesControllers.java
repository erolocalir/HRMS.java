package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CandidatesService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Candidates;
import kodlama.io.hrms.entities.concretes.verification.VerificationToCandidates;

@RestController
@RequestMapping("/api/Candidates")

public class CandidatesControllers {
	
	private CandidatesService candidatesService;

	@Autowired
	public CandidatesControllers(CandidatesService candidatesService) {
		super();
		this.candidatesService = candidatesService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidates>> getAll(){
		return candidatesService.getAll();
			
	}
	
	@PostMapping("/verify")
	public Result add(@RequestBody VerificationToCandidates employee) {
		return this.candidatesService.validation(employee);
		
	}
	
	@PostMapping("/socialmediaaccount")
	public Result add(@RequestBody Candidates candidates) {
		return this.candidatesService.addSocialMediaAccount(candidates);
				
	}
	
	@PostMapping("/ability")
	public Result add1(@RequestBody Candidates candidates) {
		return this.candidatesService.addAbility(candidates);
		
	
}
	
	@PostMapping("/school")
	public Result add2(@RequestBody Candidates candidates) {
	return this.candidatesService.addGraduatedSchool(candidates);
	
	
}
	@PostMapping("/experience")
	public Result add3(@RequestBody Candidates candidates) {
	return this.candidatesService.addJobExperience(candidates);
	
	
}
	

}






