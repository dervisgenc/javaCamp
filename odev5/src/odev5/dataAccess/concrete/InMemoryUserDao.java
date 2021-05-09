package odev5.dataAccess.concrete;

import java.util.ArrayList;
import java.util.List;

import odev5.dataAccess.abstracts.UserDao;
import odev5.entities.concrete.User;

public class InMemoryUserDao implements UserDao{
	private  List<User> users = new ArrayList<User>();
	public InMemoryUserDao() {
		User user1=new User(1,"Derviþ","Genç","xdt@gmail.com","123456",true);
		User user2=new User(2,"Halit","Özdemir","abc@gmail.com","aaa123",true);
		User user3=new User(3,"Engin","Demiroð","yyy@gmail.com","789789",true);
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}

	@Override
	public void add(User user) {
		System.out.println("Kaydýnýz baþarýlý bir þekilde tamamlandý Sn."+user.getLastName());
		users.add(user);		
	}

	@Override
	public void delete(int userId) {
		User userToDelete = users.stream()
				.filter(u -> u.getId() == userId)
				.findFirst()
				.orElse(null);
		
		users.remove(userToDelete);			
	}

	@Override
	public void update(User user) {
		User userToUpdate = users.stream()
				.filter(u -> u.getId() == user.getId())
				.findFirst()
				.orElse(null);
		
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setName(user.getName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setVerify(user.isVerify());
		System.out.println("Bilgileirniz güncellendi "+user.getName());
		
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User getMail(String email) {
		User user = users.stream()
				.filter(u -> u.getEmail() == email)
				.findFirst()
				.orElse(null);
		return user;
	}

}
