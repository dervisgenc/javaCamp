package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RequestMapping("/api/jobseekers")
@RestController
public class JobSeekerConrtroller {
	private JobSeekerService jobSeekerService;

	public JobSeekerConrtroller(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody JobSeeker jobSeeker,@RequestParam String passwordRepeat) {
		return this.jobSeekerService.add(jobSeeker,passwordRepeat);
	}
	
	@DeleteMapping
	Result delete(@RequestBody JobSeeker jobSeeker) {
		return this.jobSeekerService.delete(jobSeeker);
	}
}
