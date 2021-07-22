package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.entities.concretes.ActivationCode;

@EnableJpaRepositories
public interface ActivationCodeDao extends JpaRepository<ActivationCode, Integer>{
	  ActivationCode findByUserId(int userId);
	  ActivationCode getByUserId(int userId);
	 
	  @Modifying
	  @Transactional
	  @Query("update ActivationCode ac set ac.isVerified=true where ac.id in :id")
	  void activateUser(@Param("id") int id);
}
