package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface PersonCheckService {
	boolean checkRealPerson(JobSeeker jobSeeker);
}
