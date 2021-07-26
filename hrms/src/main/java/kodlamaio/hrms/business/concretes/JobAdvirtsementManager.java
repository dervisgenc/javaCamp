package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
@Service
public class JobAdvirtsementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvirtsementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}


	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı Eklendi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Data listelendi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByJobTitle_Name(String jobTitleName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByJobTitle_Name(jobTitleName), "Data listelendi");
	}


	@Override
	public DataResult<JobAdvertisement> getByEmployerId(int employerId) {
		
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getByEmployerId(employerId), "Data listelendi");
	}


	


	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_CompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_CompanyName(companyName), "Data listelendi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByJobTitle_NameAndEmployer_CompanyName(String name, String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByJobTitle_NameAndEmployer_CompanyName(name, companyName), "Data listelendi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByJobTitle_NameAndCity_CityName(String name, String cityName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByJobTitle_NameAndCity_CityName(name, cityName), "Data listelendi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByCity_CityName(String cityName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCity_CityName(cityName), "Data listelendi");
	}

}
