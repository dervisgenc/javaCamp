package odev3;

public class InstructerManager extends UserManager {
	public InstructerManager(Logger logger) {
		super(logger);
	}

	public void createTimeTable(Instructer ýnstructer) {
		System.out.println("Ders Çizelgesi Oluþtur");
		this.logger.log("Loglandý");
	}

	public void startLesson (Instructer ýnstructer) {
		System.out.println("Dersi Baþlat");
		this.logger.log("Loglandý");
	}
}
