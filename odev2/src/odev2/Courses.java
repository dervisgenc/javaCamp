package odev2;

public class Courses {
	public Courses() {
		System.out.println("Çalýþýyor");
	}
	public Courses(int id, String name, String teacher, double progress) {
		//this();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.progress = progress;
		
		
	}
	int id;
	String name;
	String teacher;
	double progress;

}
