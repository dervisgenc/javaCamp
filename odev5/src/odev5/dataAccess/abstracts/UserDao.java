package odev5.dataAccess.abstracts;

import java.util.List;

import odev5.entities.concrete.User;

public interface UserDao {
	void add(User user);
	void delete(int userId);
	void update(User user);
	User getMail(String eMail);
	List<User> getAll();
}
