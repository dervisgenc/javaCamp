package odev5.core;

import odev5.business.abstracts.UserService;
import odev5.entities.concrete.LoginDto;
import odev5.entities.concrete.User;

public class GoogleAuthManagerAdapter implements ExternalAuthService {
	private UserService userService;
	public GoogleAuthManagerAdapter(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void register(String email) {
		if(userExists(email)==false) {
			userService.add(null);
		}else {
			User user =userService.getMail(email);
			LoginDto dto=new LoginDto();
			dto.setEmail(user.getEmail());
			dto.setPassword(user.getPassword());
			login(dto);
		}
		
	}

	@Override
	public boolean userExists(String email) {
		if(userService.getMail(email)!=null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void login(LoginDto dto) {
		if(dto!=null && dto.getPassword().equals(dto.getPassword())) {
			System.out.println("Baþarýyla giriþ yaptýnýz");
		}else {
			System.out.println("Kullanýcý Bulunamadým");
		}
		
	}

}
