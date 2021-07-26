package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
@EnableJpaRepositories
public interface JobAdvertisementDao  extends JpaRepository<JobAdvertisement, Integer>{
	
	
	List<JobAdvertisement> getByJobTitle_Name(String jobTitle);
	
	JobAdvertisement getByEmployerId(int employerId);
	
	List<JobAdvertisement> getByJobTitle_NameAndEmployer_CompanyName(String jobTitle, String companyName);
	
	List<JobAdvertisement> getByEmployer_CompanyName(String companyName);
	
	List<JobAdvertisement> getByCity_CityName(String cityName);
	
	List<JobAdvertisement> getByJobTitle_NameAndCity_CityName(String name, String cityName);
}
