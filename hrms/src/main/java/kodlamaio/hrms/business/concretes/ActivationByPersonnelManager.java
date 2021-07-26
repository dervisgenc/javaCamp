package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationByPersonnelService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationByPersonnelDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.ActivationByPersonnel;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class ActivationByPersonnelManager implements ActivationByPersonnelService{
	private ActivationByPersonnelDao activationByPersonnelDao;
	private EmployerDao employerDao;
	
	@Autowired
	public ActivationByPersonnelManager(ActivationByPersonnelDao activationByPersonnelDao, EmployerDao employerDao) {
		super();
		this.activationByPersonnelDao = activationByPersonnelDao;
		this.employerDao = employerDao;
	}

	@Override
	public void createActivationByPersonnel(Employer employer) {
		ActivationByPersonnel activationByPersonnel=new ActivationByPersonnel();
		
		activationByPersonnel.setEmployerId(employer.getId());
		activationByPersonnel.setVerified(false);
		activationByPersonnel.setPersonnelId(0);
		activationByPersonnelDao.save(activationByPersonnel);
		
		
	}

	@Override
	public Result activateEmployer(int employerId, int personnelId) {
		Employer employer = employerDao.getById(employerId);
		ActivationByPersonnel activationByPersonnel = activationByPersonnelDao.getByEmployerId(employerId);
		
		employer.setActive(true);
		activationByPersonnel.setVerified(true);
		
		employerDao.save(employer);
		activationByPersonnelDao.save(activationByPersonnel);
		return new SuccessResult("Şirket aktif edildi");
		
		
	}

}
