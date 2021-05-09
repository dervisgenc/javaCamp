package odev3;

public class StudentManager extends UserManager {
	public StudentManager(Logger logger) {
		super(logger);
		
	}


	public void toEnrollCourse(Student students) {
		System.out.println(students.getName()+" "+students.getLastName()+" Kursa Kaydol");
		this.logger.log("Loglandý");
	}
	
	
	public void joinLesson(Student students) {
		System.out.println(students.getLessonsLearned()+" Derse Gir");
		this.logger.log("Loglandý");
	}
	
}
 