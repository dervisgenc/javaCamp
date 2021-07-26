package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	
	Result add(JobAdvertisement jobAdvertisement);

	DataResult<List<JobAdvertisement>> getByJobTitle_Name(String jobTitle);
	
	DataResult<JobAdvertisement> getByEmployerId(int employerId);
	
	DataResult<List<JobAdvertisement>> getByJobTitle_NameAndEmployer_CompanyName(String name, String companyName);
	
	DataResult<List<JobAdvertisement>> getByEmployer_CompanyName(String companyName);	
	
	DataResult<List<JobAdvertisement>> getByJobTitle_NameAndCity_CityName(String name, String cityName);
	
	DataResult<List<JobAdvertisement>> getByCity_CityName(String cityName);
	
}
