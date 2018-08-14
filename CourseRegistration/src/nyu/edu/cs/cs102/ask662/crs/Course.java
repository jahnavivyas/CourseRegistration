package nyu.edu.cs.cs102.ask662.crs;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileInputStream;

public class Course implements Comparable<Course>, Serializable {
	
	private String courseName;
	private String courseID;
	private int maxStudents;
	private int numCurrentStudents = 0;
	ArrayList<Student> studentList = new ArrayList<Student>();
	private String courseInstructor;
	private int courseSection;
	private String courseLocation;
	
	
	//constructor for class
	//getters and setters
	//to string method
	
	//@override
	
	 @Override
	//https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
	    public int compareTo(Course f) {
	        int comparecourse =((Course)f).getNumCurrentStudents();
	        /* For Ascending order*/
	        return this.numCurrentStudents-comparecourse;

	    
	    }

	    //@Override
	    //public String toString() {
	        //return "[ rollno=" + rollno + ", name=" + studentname + ", age=" + studentage + "]";
	    //}

	
	
	
	
	public Course(String courseName, String courseID, int maxStudents, int numCurrentStudents, ArrayList<Student> studentList, String courseInstructor, int courseSection, String courseLocation) {
		this.courseName = courseName;
		this.courseID= courseID;
		this.maxStudents = maxStudents;
		this.numCurrentStudents = numCurrentStudents;
		this.studentList = studentList;
		this.courseInstructor = courseInstructor;
		this.courseSection = courseSection;
		this.courseLocation = courseLocation;
	}
	
	 public ArrayList<Student> getStudentList() {
		    return studentList;
 	
	 }
	//@override
	
	
	public String toString() {
		String students = "";
		for (int i = 0; i < studentList.size(); i++) {
			students += studentList.get(i).getFirstName() + " " + studentList.get(i).getLastName();
					
		}
		return courseName + "\n" + courseID + "\n" + maxStudents + "\n" + students + "\n" + courseInstructor + "\n" + courseSection + "\n" + courseLocation;
				
			
	}
	 
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public int getMaxStudents() {
		return maxStudents;
	}
	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}
	public int getNumCurrentStudents() {
		return numCurrentStudents;
	}
	public void setNumCurrentStudents(int numCurrentStudents) {
		this.numCurrentStudents = numCurrentStudents;
	}
	public String getCourseInstructor() {
		return courseInstructor;
	}
	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}
	public int getCourseSection() {
		return courseSection;
	}
	public void setCourseSection(int courseSection) {
		this.courseSection = courseSection;
	}
	public String getCourseLocation() {
		return courseLocation;
	}
	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
}