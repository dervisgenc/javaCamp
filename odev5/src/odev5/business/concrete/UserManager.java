package odev5.business.concrete;

import java.util.List;

import odev5.business.abstracts.UserService;
import odev5.core.EmailService;
import odev5.dataAccess.abstracts.UserDao;
import odev5.entities.concrete.User;

public class UserManager implements UserService{
	private UserDao userDao;
	private EmailService emailService;
	
	public UserManager(UserDao userDao,EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService=emailService;
	}

	@Override
	public void add(User user) {
		if(userValidator(user)) {
			userDao.add(user);
			emailService.send(user.getEmail(), "Kayýt olundu");
		}
		
		
	}


	@Override
	public void delete(int userId) {
		userDao.delete(userId);
		
	}

	@Override
	public void update(User user) {
		if(userValidator(user)) {
			userDao.update(user);
		}
		
	}

	@Override
	public User getMail(String email) {
	
		return userDao.getMail(email);
	}

	@Override
	public List<User> getAll() {
		for (User user : userDao.getAll()) {
			System.out.println(user.getName()+" "+user.getLastName());
		}
		return userDao.getAll();
	}
	public boolean userValidator(User user) {
		if(user.getName().length()>2&& user.getLastName().length()>2) {
			return true;
		}else {
			System.out.println("Geçersiz Kullanýcý");
			return false;
		}
	}
}
