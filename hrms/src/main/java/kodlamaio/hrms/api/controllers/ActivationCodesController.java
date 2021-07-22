package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.results.Result;
@RestController
@RequestMapping("/api/verify")
@CrossOrigin
public class ActivationCodesController {
	private ActivationCodeService activationService;
	
	@Autowired
	public ActivationCodesController(ActivationCodeService activationService) {
		super();
		this.activationService = activationService;
	}
	
	@PostMapping("/update/{verificationCode}/{id}")
	public Result setVerify(@RequestParam String code,@RequestParam Integer id) {
		return this.activationService.verifyCode(code, id);
	}
}
