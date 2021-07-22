package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ActivationByPersonnelService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/activationbypersonnel")
public class ActivationByPersonnelController {
	private ActivationByPersonnelService activationByPersonnelService;

	@Autowired
	public ActivationByPersonnelController(ActivationByPersonnelService activationByPersonnelService) {
		super();
		this.activationByPersonnelService = activationByPersonnelService;
	}
	
	@PostMapping("/activateemployer")
	public Result setActive( int employerId, int personnelId) {
		return this.activationByPersonnelService.activateEmployer(employerId, personnelId);
	}
	
}
