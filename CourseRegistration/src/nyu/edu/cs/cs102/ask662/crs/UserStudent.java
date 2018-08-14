package nyu.edu.cs.cs102.ask662.crs;

import java.util.ArrayList;

public interface UserStudent {
	
	public void viewCourses(ArrayList<Course> courses);
	
	public void viewAvailableCourses(ArrayList<Course> courses);
	
	public void registerStudent(ArrayList<Course> courses, ArrayList<Student> students);
	
	public void withdraw(ArrayList<Course> courses, ArrayList<Student> students);
	
	public void viewStudentCourses();
	
	public void exitProgram(); 
	
	

}
