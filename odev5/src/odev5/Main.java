package odev5;



import odev5.business.concrete.AuthManager;
import odev5.business.concrete.UserManager;
import odev5.core.googleEmail.GoogleMailManagerAdapter;
import odev5.dataAccess.concrete.InMemoryUserDao;
import odev5.entities.concrete.User;

public class Main {

	public static void main(String[] args) {
		
		InMemoryUserDao inMemoryUserDao=new InMemoryUserDao();
		AuthManager authManager=new AuthManager(new UserManager(inMemoryUserDao, 
				new GoogleMailManagerAdapter()));
		
		User user4=new User(2,"Derviþ","Genç","xdtasd@gmail.com","123456",true);
		User user5=new User(5,"AAAas","ASDasa","dervis.genc.462002@gmail.com","12456456",true);
		UserManager userManager=new UserManager(new InMemoryUserDao(), new GoogleMailManagerAdapter());
		authManager.register(user5);
		userManager.update(user4);
		
	}

}
