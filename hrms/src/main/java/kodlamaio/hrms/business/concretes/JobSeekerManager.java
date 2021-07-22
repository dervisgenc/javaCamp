package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.PersonCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.concretes.JobSeeker;
@Service
public class JobSeekerManager implements JobSeekerService{
	private JobSeekerDao jobSeekerDao;
	
	private PersonCheckService personCheckService;
	
	private ActivationCodeService activationCodeService;
	
	@Autowired
	public JobSeekerManager(PersonCheckService personCheckService,JobSeekerDao jobSeekerDao,ActivationCodeService activationCodeService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.personCheckService = personCheckService;
		this.activationCodeService=activationCodeService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"Adaylar başarıyla listelendi");
	}

	@Override
	public DataResult<JobSeeker> getJobSeekerByNationalId(String nationalId) {
		
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByNationalId(nationalId));
	}

	@Override
	public DataResult<JobSeeker> getJobSeekerByEmail(String email) {
	
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByEmail(email));
	}

	@Override
	public Result add(JobSeeker jobSeeker,String passwordRepeat) {
		if(isPasswordRepeatTrue(jobSeeker, passwordRepeat)==false) {
			return new ErrorResult("Şifreleriniz uyuşmuyor");
		}
		if(jobSeekerDao.findByNationalId(jobSeeker.getNationalId()) != null || jobSeekerDao.findByEmail(jobSeeker.getEmail()) != null) {
			return new ErrorResult("Bu bilgiler ile kullanıcı mevcut!!");
		}
		if(jobSeeker.getEmail().isBlank() || jobSeeker.getPassword().isBlank() ||jobSeeker.getFirstName().isBlank() || jobSeeker.getLastName().isBlank()  || jobSeeker.getNationalId().isBlank()) {
			return new ErrorResult("Boş alan bırakmayınız");
		}
		if(personCheckService.checkRealPerson(jobSeeker)) {
			
			this.jobSeekerDao.save(jobSeeker);
			this.activationCodeService.createCode(new ActivationCode(), jobSeeker);
			return new SuccessResult("Kullanıcı başarıyla kaydedildi");
		}else {
			return new ErrorResult("Bilgilerinizin doğru olduğundan emin olunuz");
		}
		
		
	}
	private boolean isPasswordRepeatTrue(JobSeeker jobSeeker,String passwordRepeat) {
		if (!jobSeeker.getPassword().equals(passwordRepeat)) {
			return false;
		}
		
		return true;
	
		}

	@Override
	public Result delete(JobSeeker jobSeeker) {
		this.jobSeekerDao.delete(jobSeeker);
		return new SuccessResult("Kullanıcı Silindi");
	}
	

}
