package odev3;

public class UserManager {
	Logger logger;
	public UserManager(Logger logger) {
		this.logger=logger;
	}
	public void editProfile(User user) {
		System.out.println("Profile Düzenle");
		this.logger.log("Loglandý");
	}
	public void signOut() {
		System.out.println("Çýkýþ yap");
	}
}
