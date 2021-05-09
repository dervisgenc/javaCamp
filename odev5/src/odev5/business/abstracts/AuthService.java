package odev5.business.abstracts;

import odev5.entities.concrete.LoginDto;
import odev5.entities.concrete.User;

public interface AuthService {
	void register(User user);
	void verify(User user,String token);
	boolean userExists(String email);
	void login(LoginDto dto);
}
