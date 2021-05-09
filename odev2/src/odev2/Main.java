package odev2;

public class Main {

	public static void main(String[] args) {
		Courses course1 = new Courses();
		course1.id = 1;
		course1.name ="Java Kursu";
		course1.teacher="Engin Demiroğ";
		course1.progress= 0.13;
		
		Courses course2 = new Courses(2,"C# Kursu","Engin Demiroğ",0.5);
		
		Courses[] courses = {course1,course2};
		for(Courses kurslar : courses) {
			System.out.println(kurslar.name);
		}
		
		CoursesManager coursesManager = new CoursesManager();
		coursesManager.toRegisterCourse(course1);
		coursesManager.courseContent(course1);
		coursesManager.toRegisterCourse(course2);
		coursesManager.courseContent(course2);
		
		
	}

}
