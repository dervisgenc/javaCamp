package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.ActivationByPersonnel;

public interface ActivationByPersonnelDao extends JpaRepository<ActivationByPersonnel, Integer> {
	
	ActivationByPersonnel getByEmployerId( int id);
}
