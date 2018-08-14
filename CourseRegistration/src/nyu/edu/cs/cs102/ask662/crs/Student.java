package nyu.edu.cs.cs102.ask662.crs;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Student extends User implements UserStudent, java.io.Serializable {
	
	/**private static String Username;
	private static String Password;
	private String firstName;
	private String lastName**/
	
	public Student(String firstname, String lastname, String Username, String Password) {
		super(firstname, lastname, Username, Password);
	}
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//@Override
	//public String getFullName() {
		//return firstName + " " + lastName;
	//}
	public ArrayList<Course> courses = new ArrayList<Course>();
		
	 
	public void viewCourses(ArrayList<Course> courses) {
		for (int i = 0; i < courses.size(); i++) {
				System.out.println(courses.get(i));
		}
	}
	
	public void viewAvailableCourses(ArrayList<Course> courses) {
		//is there another arraylist for open 
		System.out.println("Available courses:");
		for (int i = 0; i < (courses).size(); i++) {
			if (courses.get(i).getMaxStudents() > courses.get(i).getNumCurrentStudents()) {
				System.out.println(courses.get(i).getCourseName());
			}
		}
	}
		
	
	
	public void registerStudent(ArrayList<Course> courses, ArrayList<Student> students) {
		Scanner scann = new Scanner(System.in);
		System.out.println("Enter the course name");
		String courseName = scann.nextLine();
		System.out.println("Enter the course section");
		int courseSection = Integer.parseInt(scann.nextLine());
		System.out.println("Enter your first name");
		String firstName = scann.nextLine();
		System.out.println("Enter your last name");
		String lastName = scann.nextLine();
		//do we add to students arraylist
		Student studd = null;
		for (int i =0; i < students.size(); i++) {
			if ((students.get(i).getFirstName().equals(firstName)) && (students.get(i).getLastName().equals(lastName))) {
				studd = students.get(i);
			}
		}
		if (studd != null) {
			//students.add(studd);
			for (int i = 0; i < courses.size(); i++) {
				if (courses.get(i).getCourseName().equals(courseName)) {
					courses.get(i).getStudentList().add(studd);
					studd.courses.add(courses.get(i));
					courses.get(i).setNumCurrentStudents(courses.get(i).getNumCurrentStudents()+1);
					//System.out.println("hi");
					//int courses.get(i).getNumCurrentStudents()++;
				}
			}
			
		}
		else {
			System.out.println("Student does not exist.");
		}
		
		
		//Does this student object already exist??
		//do we "pluck" it out of the students??
		//is there a master student arraylist of all students, or is it just a parameter of courses??
		//add student to list
	}
	
	public void withdraw(ArrayList<Course> courses, ArrayList<Student> students) {
		Scanner sns = new Scanner(System.in);
		System.out.println("Enter your first name");
		String firstName = sns.nextLine();
		System.out.println("Enter your last name");
		String lastName = sns.nextLine();
		System.out.println("Enter the course name");
		String courseName = sns.nextLine();
		System.out.println("Enter the course section");
		int courseSection = Integer.parseInt(sns.nextLine());
		Student stude = null;
		for (int i =0; i < students.size(); i++) {
			if ((students.get(i).getFirstName().equals(firstName)) && (students.get(i).getLastName().equals(lastName))) {
				stude = students.get(i);
			}
		}
		if (stude != null) {
			for (int i = 0; i < courses.size(); i++) {
				if (courses.get(i).getCourseName().equals(courseName)) {
					courses.get(i).getStudentList().remove(stude);
					stude.courses.remove(courses.get(i));
					courses.get(i).setNumCurrentStudents(courses.get(i).getNumCurrentStudents()-1);
					
					//System.out.println("hi");
					//int courses.get(i).getNumCurrentStudents()++;
				}
			}
			
		}
		else {
			System.out.println("Student does not exist.");
		}
			
		}
			//students.add(stude);
		//remove student from course's list
		/**for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getCourseName().equals(courseName)) {
				for (int k = 0; k < students.size(); k++) {
					if ((students.get(k).equals(firstName)) && (courses.get(k).equals(lastName))) {
						Student stud = null;
						stud = new Student(firstName, lastName, stud.getUsername(), stud.getPassword() );
						courses.get(i).getStudentList().remove(stud);
						int a = courses.get(i).getNumCurrentStudents();
						a--;**/
			
		
		
		
		//do we create then remove them????????
		
	
	
	public void viewStudentCourses() {
		for (int i = 0; i <  courses.size(); i++) {
			System.out.println(courses.get(i).getCourseName());
			}
		}
		
					
		
		
	
	
			
	
	
	public void exitProgram() {
		System.out.println("Logging off...");
		System.exit(0);
		
	}

	
	

	
	

	
}
