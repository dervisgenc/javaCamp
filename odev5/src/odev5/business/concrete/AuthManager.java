package odev5.business.concrete;

import odev5.business.abstracts.AuthService;
import odev5.business.abstracts.UserService;
import odev5.core.utils.Utils;
import odev5.entities.concrete.LoginDto;
import odev5.entities.concrete.User;

public class AuthManager implements AuthService {
	private UserService userService;

	public AuthManager(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void register(User user) {
		if (userValidate(user) && passwordValidate(user.getPassword()) && userExists(user.getEmail()) == false
				&& Utils.emailValidate(user.getEmail())) {
			userService.add(user);
		}else {
			System.out.println("Kayıt başarısız");
		}
	}

	@Override
	public void verify(User user, String token) {
		if(user!=null ) {
			User exitsUser=userService.getMail(user.getEmail());
			exitsUser.setVerify(true);
			userService.update(exitsUser);
			System.out.println("Doğrulandı");
		}
		System.out.println("Doğrulanamadı");
	}

	@Override
	public boolean userExists(String email) {
		User user=userService.getMail(email);
		if(user==null) {
			return false;
		}else {
			System.out.println("Email mevcut "+email);
			return true;
		}
	}

	@Override
	public void login(LoginDto dto) {
		User user =userService.getMail(dto.getEmail());
		if(user!=null && user.getPassword().equals(dto.getPassword())) {
			System.out.println("Hoşgeldiniz");
		}else {
			System.out.println("Kulanıcı adı veya Şifre yanlış");
		}
		

	}
	public boolean userValidate(User user) {
		if (user != null && !user.getName().isEmpty() && !user.getLastName().isEmpty() && !user.getEmail().isEmpty()
				&& user.getPassword().isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean passwordValidate(String password) {
		if (password.length() >= 6) {
			return true;
		} else {
			System.out.println("Şifreni en az 6 karakter  olmalıdır");
			return false;
		}
	}


	

}
