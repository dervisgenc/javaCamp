package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;
@Service
public class JobTitleManager implements JobTitleService {
	private JobTitleDao jobTitleDao;
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"Data listelendi" );
				
	}

	@Override
	public DataResult<JobTitle> getByName(String name) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.findByName(name));
	}
	
	@Override
	public Result add(JobTitle jobTitle) {
		if(jobTitleDao.findByName(jobTitle.getName()) != null) {
			return new  ErrorResult("İş pozisyonu mevcut!!");
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İş pozisyonu eklendi");
	}


}
