package nyu.edu.cs.cs102.ask662.crs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable {
	
	//ArrayList<Course> courses = new ArrayList<Course>();
	//ArrayList<Student> students = new ArrayList<Student>();
	
	protected  String Username;
	protected String Password;
	protected String firstName;
	protected String lastName;
	//first name last name username password
	
	public void viewCourses(ArrayList<Course> courses) {
		for (int i = 0; i < ((CharSequence) courses).length(); i++) {
				System.out.println(courses.get(i));
		}
	}
	
	public void exitProgram() {
		System.out.println("Logging off...");
		System.exit(0);
		
	}
	
	public User(String firstName, String lastName, String Username, String Password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.Username = Username;
		this.Password = Password;
	}
	
	public User() {
		
	}
	/**public void viewStudentCourses(ArrayList<Course> courses) {
		System.out.println("Enter first name:");
		Scanner sccn = new Scanner(System.in);
		String firstnamee = sccn.next();
		System.out.println("Enter last name:");
		String lastnamee = sccn.next();
		for (int i = 0; i < ((CharSequence) courses).length(); i++) {
			if ((courses.get(i).getStudentList().equals(firstnamee)) && (courses.get(i).getStudentList().equals(lastnamee))) {
			System.out.println(courses.get(i));
			}
		}
		
	}**/
	
	public void viewStudentCourses(ArrayList<Student> students) {
		System.out.println("Enter first name:");
		Scanner sccn = new Scanner(System.in);
		String firstnamee = sccn.nextLine();
		System.out.println("Enter last name:");
		String lastnamee = sccn.nextLine();
		for (int i = 0; i < ( students).size(); i++) {
			if ((students.get(i).getFirstName().equals(firstnamee)) && (students.get(i).getLastName().equals(lastnamee))) {
				students.get(i).viewStudentCourses();
			
			}
		}
	
	
}
}
	
	
	
	
