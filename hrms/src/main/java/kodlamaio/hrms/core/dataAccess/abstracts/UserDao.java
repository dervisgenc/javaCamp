package kodlamaio.hrms.core.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
