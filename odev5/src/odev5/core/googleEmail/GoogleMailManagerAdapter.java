package odev5.core.googleEmail;

import odev5.core.EmailService;
import odev5.googleEmail.GoogleMailManager;

public class GoogleMailManagerAdapter implements EmailService {
	private GoogleMailManager googleMailManager;
	public GoogleMailManagerAdapter() {
		super();
		this.googleMailManager = new GoogleMailManager();
	}
	@Override
	public void send(String email, String message) {
		googleMailManager.send(email, message);
		
	}

}
