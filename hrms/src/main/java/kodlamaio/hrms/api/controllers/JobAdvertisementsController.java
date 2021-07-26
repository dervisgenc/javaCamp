package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
		
	}
	@GetMapping("/getbyemployerid")
	public DataResult<JobAdvertisement> getByEmployerId(@RequestParam int employerId){
		return this.jobAdvertisementService.getByEmployerId(employerId);
	}
	
	@GetMapping("/getbycompanyname")
	public DataResult<List<JobAdvertisement>> getByEmployer_CompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.getByEmployer_CompanyName(companyName);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getbyjobtitle")
	public DataResult<List<JobAdvertisement>> getByJobTitle_Name(@RequestParam String jobTitle) {
		return this.jobAdvertisementService.getByJobTitle_Name(jobTitle);
	}
	
	@GetMapping("/getbyjobtitleandcompanyname")
	public DataResult<List<JobAdvertisement>> getByJobTitle_NameAndEmployer_CompanyName(@RequestParam String jobPosition, String companyName) {
		return this.jobAdvertisementService.getByJobTitle_NameAndEmployer_CompanyName(jobPosition,companyName);
	}
}
