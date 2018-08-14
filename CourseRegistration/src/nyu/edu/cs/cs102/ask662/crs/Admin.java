package nyu.edu.cs.cs102.ask662.crs;
import java.io.*;
import java.util.Scanner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Admin extends User implements UserAdmin, java.io.Serializable {
	
	

	 
	
	//public Admin() {
	
	//}
	
	public Admin() {
		super();
		Username = "Admin";
		Password = "Admin001";
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String adminUsername) {
		this.Username = adminUsername;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String adminPassword) {
		this.Password = adminPassword;
		
	}	
	public void createCourse(ArrayList<Course> courses) {
		Scanner sccann = new Scanner(System.in);
		System.out.println("What is the course name?");
		String courseName = sccann.nextLine();
		System.out.println("What is the course ID?");
		String courseID = sccann.nextLine();
		System.out.println("What is the maximum number of students that can register in this class?");
		int maxStudents = Integer.parseInt(sccann.nextLine());
		System.out.println("Who is the course instructor?");
		String courseInstructor = sccann.nextLine();
		System.out.println("What is the course section number?");
		int courseSection = Integer.parseInt(sccann.nextLine());
		System.out.println("What is the course location?");
		String courseLocation = sccann.nextLine();
		int currentStudents = 0;
		ArrayList<Student> studentss = new ArrayList<Student>();
		System.out.println("0 students are currently registered.");
		System.out.println("The roster for this class is currently empty.");
		Course course = new Course(courseName, courseID, maxStudents, currentStudents, studentss, courseInstructor, courseSection, courseLocation);
		courses.add(course);
		
		
	
	}
	
	
	public void deleteCourse(ArrayList<Course> courses) {
		Scanner scannn = new Scanner(System.in);
		System.out.println("Which course would you like to delete?");
		String del = scannn.nextLine();
		for (int i = 0; i < (courses).size(); i++) {
			if (courses.get(i).getCourseName().equals(del)) {
				courses.remove(courses.get(i));
			}
		}
		//iterate through whole arraylist
	}
	
	public void editCourse(ArrayList<Course> courses) {
		Scanner scannn = new Scanner(System.in);
		System.out.println("Which course would you like to edit?");
		String coursename = scannn.nextLine();
		for (int i = 0; i < ( courses).size(); i++) {
			if (courses.get(i).getCourseName().equals(coursename)) {
				System.out.println("Would you like to edit the course name, the Course ID, or the instructor name?");
				String reply = scannn.nextLine();
				if (reply.toLowerCase().equals("course name")) {
					System.out.println("What is the updated course name?");
					String crsename = scannn.nextLine();
					courses.get(i).setCourseName(crsename);
					///
				}
				else if (reply.toLowerCase().equals("course id")) {
					System.out.println("What is the updated Course ID?");
					String courseidd = scannn.nextLine();
					courses.get(i).setCourseID(courseidd);
					///
				}
				else if (reply.toLowerCase().equals("instructor name")) {
					System.out.println("What is the updated instructor name?");
					String profname = scannn.nextLine();
					courses.get(i).setCourseInstructor(profname);
					
				//
				}
				
				
			}
		}
		//iterate through arraylist ????? how do we look up course
		
		
	}
	
	public void displayCourse(ArrayList<Course> courses) {
		Scanner sccan = new Scanner(System.in);
		System.out.println("Enter Course ID:");
		String courseid = sccan.nextLine();
		for (int i = 0; i < (courses.size()); i++) {
			if (courses.get(i).getCourseID().equals(courseid)) {
			System.out.println(courses.get(i));
			}
		}
			
	}
	
	public void registerStudent(ArrayList<Student> students) {
		Scanner ssccan = new Scanner(System.in);
		System.out.println("What is the first name of the student you want to register?");
		String firstname = ssccan.nextLine();
		System.out.println("What is the last name of the student you want to register?");
		String lastname = ssccan.nextLine();
		System.out.println("What is the student's username?");
		String username = ssccan.nextLine();
		System.out.println("What is the student's password?");
		String password = ssccan.nextLine();
		Student student =  new Student(firstname, lastname, username, password);
		students.add(student);
		//first name
		//last name
	
	
		
	}
	
	public void exitProgram() {
		System.out.println("Logging off...");
		System.exit(0);
	
		
	}
	
	public void viewCourses(ArrayList<Course> courses) {
		for (int i = 0; i < (( courses).size()); i++) {
				System.out.println(courses.get(i));
		}
	}
	
	/**public void viewFull(ArrayList<Course> courses) {
		System.out.println("Full courses:");
		ArrayList<Course> coursesFull = new ArrayList<Course>();
		for (int i = 0; i < (( courses).size()); i++) {
			if(courses.get(i).getNumCurrentStudents() == courses.get(i).getMaxStudents()) {
				coursesFull.add(courses.get(i));
			}
		}
		for (int i = 0; i < (( coursesFull).size()); i++) {
			System.out.println(coursesFull.get(i).getCourseName());
		}
		
	}
		//arraylist for full courses??
		//just print out those with less than max students
		
		
	
	
	public void writeFile(ArrayList<Course> courses) {
				System.out.println("Creating file...");
				String fileName = "CoursesFull.txt";
				
				try{
					FileWriter fileWriter = new FileWriter(fileName);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					
					for (int i = 0; i < (( courses).size()); i++) {
						if (courses.get(i).getNumCurrentStudents() == courses.get(i).getMaxStudents()) {
							String fill = courses.get(i).getCourseName();
							bufferedWriter.write(fill);
							bufferedWriter.newLine();

						}
					}
		//Always close writer
					bufferedWriter.close();
				}

				//Always close files

				catch (IOException exk) {
					System.out.println( "Error writing file '" + fileName + "'");
					exk.printStackTrace();
				}
			}**/
		
		//
	
	public void viewFull(ArrayList<Course> courses) {
		System.out.println("Full courses:");
		ArrayList<Course> coursesFull = new ArrayList<Course>();
		for (Course cf: courses) {
			if(cf.getNumCurrentStudents() >= cf.getMaxStudents()) {
				coursesFull.add(cf);
			}
		}
		for(Course cf: coursesFull) {
			System.out.println(cf.getCourseName());
		}
		
	}
		//arraylist for full courses??
		//just print out those with less than max students
		
		
	
	
	public void writeFile(ArrayList<Course> courses) {
				System.out.println("Creating file...");
				String fileName = "CoursesFull.txt";
				Scanner scan = new Scanner(System.in);
				
				try{
					FileWriter fileWriter = new FileWriter(fileName);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					//String text = scan.nextLine();
					//bufferedWriter.write(text);
					
					for(Course c: courses) {
						if (c.getNumCurrentStudents() >= c.getMaxStudents()) {
							String full = c.getCourseName();
							bufferedWriter.write(full);
							bufferedWriter.newLine();

						}
					}
		//Always close writer
					bufferedWriter.close();
				}

				//Always close files

				catch (IOException exk) {
					System.out.println( "Error writing file '" + fileName + "'");
					exk.printStackTrace();
				}
			}
		
		//
		
		
		
	
	public void viewRegistered(ArrayList<Course> courses) {
		Scanner scnn = new Scanner(System.in);
		System.out.println("Enter the name of the course:");
		String coursee = scnn.nextLine();
		for (int i = 0; i < (( courses).size()); i++) {
			if (courses.get(i).getCourseName().equals(coursee)) {
				String students = "";
				ArrayList<Student> studentList = courses.get(i).getStudentList();
				for (int j = 0; j < studentList.size(); j++) {
					students += studentList.get(j).getFirstName() + " " + studentList.get(j).getLastName() +"\n";
							
				}
				System.out.println(students);
					//no getter for arraylist??
			}
		}
		
		 
		
	}
	
	public void viewStudentCourses(ArrayList<Student> students) {
		System.out.println("Enter first name:");
		Scanner sccn = new Scanner(System.in);
		String firstnamee = sccn.nextLine();
		System.out.println("Enter last name:");
		String lastnamee = sccn.nextLine();
		for (int i = 0; i < ( students).size(); i++) {
			if ((students.get(i).getFirstName().equals(firstnamee)) && (students.get(i).getLastName().equals(lastnamee))) {
				students.get(i).viewStudentCourses();
				break;
			
			}
		}
		
					
		
		
	}
	
	public ArrayList<Course> sort(ArrayList<Course> courses) {
		System.out.println("Sorting courses...");
		Collections.sort(courses);
		for (int i = 0; i < (courses).size(); i++) { 
			System.out.println(courses.get(i).getCourseName());
		}
		return courses;
		
	//how do we access the num of students parameter of each object in the arraylist??
	}
	
	
	
	
	
	
	
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	


}
		



