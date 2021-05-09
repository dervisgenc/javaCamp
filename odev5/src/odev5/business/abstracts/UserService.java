package odev5.business.abstracts;

import java.util.List;

import odev5.entities.concrete.User;

public interface UserService {
	void add(User user);
	void delete(int userId);
	void update(User user);
	User getMail(String email);
	List<User> getAll();
	
}
