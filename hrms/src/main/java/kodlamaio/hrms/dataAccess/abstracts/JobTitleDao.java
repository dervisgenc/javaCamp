package kodlamaio.hrms.dataAccess.abstracts;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import kodlamaio.hrms.entities.concretes.JobTitle;
@EnableJpaRepositories
public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{
	JobTitle findByName(String name);
}
