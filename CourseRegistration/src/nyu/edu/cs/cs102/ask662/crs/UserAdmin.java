package nyu.edu.cs.cs102.ask662.crs;

import java.util.ArrayList;

public interface UserAdmin  {
	
	public void createCourse(ArrayList<Course> courses);
	
	public void deleteCourse(ArrayList<Course> courses);
	
	public void editCourse(ArrayList<Course> courses);
	
	public void displayCourse(ArrayList<Course> courses);
	
	public void registerStudent(ArrayList<Student> students);
	
	public void exitProgram();
	
	public void viewCourses(ArrayList<Course> courses);
	
	public void viewFull(ArrayList<Course> courses);
	
	public void writeFile(ArrayList<Course> courses);
	
	public void viewRegistered(ArrayList<Course> courses);
	
	public void viewStudentCourses(ArrayList<Student> students);
	
	public ArrayList<Course> sort(ArrayList<Course> courses);
	
	
	
	
}
