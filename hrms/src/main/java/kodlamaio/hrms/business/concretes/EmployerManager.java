package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationByPersonnelService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	private ActivationByPersonnelService activationByPersonnelService;
	@Autowired
	public EmployerManager(EmployerDao employerDao,ActivationByPersonnelService activationByPersonnelService) {
		super();
		this.employerDao = employerDao;
		this.activationByPersonnelService=activationByPersonnelService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi");
	}

	@Override
	public Result add(Employer employer,String passwordRepeat) {
		if(isPasswordRepeatTrue(employer, passwordRepeat)==false) {
			return new ErrorResult("Şifreleriniz uyuşmuyor");
		}
		if(!isEmailExist(employer)) {
			return new ErrorResult("Bu email mevcut");
		}
		employer.setActive(false);
		this.employerDao.save(employer);
		activationByPersonnelService.createActivationByPersonnel(employer);
		return new SuccessResult("Şirket başarıyla kaydedildi");
	}
	
	
	private boolean isEmailExist(Employer employer) {
		if(employerDao.findByEmail(employer.getEmail()) !=null) {
			return false;
		}
		return true;
	}
	private boolean isPasswordRepeatTrue(Employer employer,String passwordRepeat) {
		if (!employer.getPassword().equals(passwordRepeat)) {
			return false;
		}
		
		return true;
	
		}

	@Override
	public DataResult<Employer> getEmployerByEmail(String email) {

		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email));
	}
		
	

	
}
