package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;
@RestController
@RequestMapping("/api/systememployees")
public class SystemPersonnelController {
	private SystemPersonnelService systemEmployeeService;
	@Autowired
	public SystemPersonnelController(SystemPersonnelService systemEmployeeService) {
		super();
		this.systemEmployeeService = systemEmployeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SystemPersonnel>> getAll(){
		return this.systemEmployeeService.getAll();
	}
	
	@PostMapping("/add")
	Result add(@RequestBody SystemPersonnel systemEmployee) {
		return this.systemEmployeeService.add(systemEmployee);
	}
	
	
}
