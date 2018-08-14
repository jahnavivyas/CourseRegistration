package nyu.edu.cs.cs102.ask662.crs;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
 

public class CourseRegistrationMain {
	
	

	
	public static void main (String[] args) throws FileNotFoundException {
		
		 ArrayList<Course> courses = new ArrayList<Course>();
		 ArrayList<Student> students = new ArrayList<Student>();
		
		
		Boolean flagMe = true;
		String file = "UniversityCourses.ser";
		//should this be courses.ser??
		File f = new File(file);
		String filef = "students.ser";
		File h = new File(filef);
				
		
		
			Scanner scan = new Scanner(new File("MyUniversityCourses.csv"));
			//String [][] myCourseDirectory = new String[29][8];
			
			String [] myBuffer;
			String bufferString = "";
			scan.nextLine();
			while (scan.hasNextLine()) {
				bufferString = scan.nextLine();
				
				myBuffer = bufferString.split(",");
				String coursename = myBuffer[0];
				String courseid = myBuffer[1];
				int maxstuds = Integer.parseInt(myBuffer[2]);
				int currstuds = Integer.parseInt(myBuffer[3]);
				ArrayList<Student> stud = new ArrayList<Student>();
				String courseprof = myBuffer[5];
				int coursesec = Integer.parseInt(myBuffer[6]);
				String courselocation = myBuffer[7];
				
				
				//int myFill = 0;
				Course c = new Course(coursename, courseid, maxstuds, currstuds, stud, courseprof, coursesec, courselocation);
				courses.add(c);
				//myFill++;
				
			}
			//System.out.println(courses.size());
			scan.close();
		
		
		
		if (f.exists()) {
		
	
			
	
	
					//Now we will deserialize the same object
					
					 try{
						  //FileInputSystem recieves bytes from a file
					      FileInputStream fis = new FileInputStream("UniversityCourses.ser");
					      
					      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
					      ObjectInputStream ois = new ObjectInputStream(fis);
					      
					      //Cast as Employee. readObject will take the object from ObjectInputStream
					      courses = (ArrayList<Course>)ois.readObject();
					      ois.close();
					      fis.close();
					    }
					    catch(IOException ioe) {
					       ioe.printStackTrace();
					       return;
					    }
					 catch(ClassNotFoundException cnfe) {
					       cnfe.printStackTrace();
					       return;
					     }
					   

					 
				
		}
		
		if (h.exists()) {
		
		//Now we will deserialize the same object
		
		 try{
			  //FileInputSystem recieves bytes from a file
		      FileInputStream fish = new FileInputStream("students.ser");
		      
		      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
		      ObjectInputStream oish = new ObjectInputStream(fish);
		      
		      //Cast as Employee. readObject will take the object from ObjectInputStream
		      students = (ArrayList<Student>)oish.readObject();
		      oish.close();
		      fish.close();
		    }
		    catch(IOException ioe) {
		       ioe.printStackTrace();
		       return;
		    }
		 	catch(ClassNotFoundException cnfe) {
		       cnfe.printStackTrace();
		       return;
		 	}
		}
		   

		 
	
				

		
		
		
		/**if (f.exists()) {
		
			try {
			
				FileInputStream filef = new FileInputStream(file);
				ObjectInputStream input = new ObjectInputStream(filef);
				
				courses = (ArrayList<Course>)input.readObject();
				
				input.close();
				filef.close();
				
			}
			
			
			catch (IOException e) {
				System.out.println("Exception is caught!");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}**/
		

					
		
							
			while (flagMe) {
				System.out.println("Welcome! Are you a student or admin?");
				Scanner scn = new Scanner(System.in);
				String response = scn.next();
				if (response.toLowerCase().equals("admin")) {
					
				
				
				System.out.println("Enter username:");
				String username = scn.next();
				System.out.println("Enter password:");
				String password = scn.next();
				Admin admin1 = new Admin();
				if ((username.equals(admin1.getUsername()) && password.equals(admin1.getPassword()))){
					//to lower case
					//successful login??
					while (true) {
					System.out.println("Course Management:\r\n"+
							"1. Create a new course\r\n" + 
							"2. Delete a course\r\n" + 
							"3. Edit a course\r\n" + 
							"4. Display information for a given course\r\n" + 
							"5. Register a student\r\n" + 
							"6.Exit\r\n" +
							"Reports:\r\n" +
							"7.View all courses\r\n" + 
							"8.View all courses that are full\r\n" +
							"9.Write to a file the list of courses that are Full\r\n" +
							"10.View the names of the students being registered in a specific course\r\n" +
							"11.View the list of courses that a given student is being registered on\r\n"+
							"12. Sort courses based on the current number of students registered\r\n" +
							"13. Exit\r\n ");
					int adminResponse = scn.nextInt();
					if(adminResponse == 1) {
						admin1.createCourse(courses);
					}
					if(adminResponse == 2) {
						admin1.deleteCourse(courses);
					}
					if(adminResponse == 3){
						admin1.editCourse(courses);	
					}
					if(adminResponse ==4) {
						admin1.displayCourse(courses);
					}
					if(adminResponse == 5) {
						admin1.registerStudent(students);	
					}
					if(adminResponse == 6) {
						admin1.exitProgram();
					}
					if(adminResponse == 7) {
						admin1.viewCourses(courses);
						//System.out.println("hi");
					}
					if(adminResponse == 8) {
						admin1.viewFull(courses);
					}
					if(adminResponse == 9) {
						admin1.writeFile(courses);
					}
					if(adminResponse == 10) {
						admin1.viewRegistered(courses);
					}
					if(adminResponse ==11) {
						admin1.viewStudentCourses(students);
					}
					if(adminResponse ==12){
						admin1.sort(courses);
						
					} 
					serializeStudents(students);
					serializeCourses(courses);
					
					if(adminResponse == 13) {
						admin1.exitProgram();
					}
				}
				}
				}
				else if (response.toLowerCase().equals("student")) {
					System.out.println("Enter username:");
					String username = scn.next();
					System.out.println("Enter password:");
					String password = scn.next();
				Student student1 = null;
				for (int i = 0; i < ( students).size(); i++) {
					if ((students.get(i).getUsername().equals(username)) && (students.get(i).getPassword().equals(password))) {
							student1 = students.get(i);
						}
					}
					//does this apply to a specific student??
					if (student1 == null) {
						System.out.println("Sorry! Cannot log in.");
						
					}
					else { 
					while (true) {
						//to lower case
						//successful login??
					System.out.println("Course Management:\r\n"+
								"1. View all courses that are available\r\n"+
								"2. View all courses that are not FULL\r\n"+
								"3. Register on a course\r\n"+
								"4. Withdraw from a course\r\n"+
								"5. View all courses that you are registered in\r\n"+
								"6. Exit\r\n");
					int studentResponse = scn.nextInt();
					if(studentResponse == 1) {
						student1.viewCourses(courses);
					}
					if(studentResponse ==2) {
						student1.viewAvailableCourses(courses);
					}
					if(studentResponse == 3) {
						student1.registerStudent(courses, students);
					}
					if(studentResponse == 4) {
						student1.withdraw(courses, students);
					}
					if(studentResponse == 5) {
						student1.viewStudentCourses();
					}
					serializeStudents(students);
					serializeCourses(courses);
					if(studentResponse == 6) {
						student1.exitProgram();
					}
					}
				}
				}
					
				
				
				
				//how to log out as admin then log in as student????
				
					
			/**try {
				FileOutputStream stream = new FileOutputStream(file);
				ObjectOutputStream output = new ObjectOutputStream(stream);
				
				output.writeObject(courses);
				
				output.close();
				stream.close();
				
			}
			
			catch(IOException e) {
				e.printStackTrace();
				
			}**/
				}
					//instantiate an Employee object
					//Course serializedCourse = new Course(file, file, 0, 0, students, file, 0, file);
					//Course du = null;
			/**public void serializeCourses() {
					try {
						//FileOutput Stream writes data to a file
						FileOutputStream fos = new FileOutputStream("UniversityCourses.ser");
						
						//ObjectOutputStream writes objects to a stream (A sequence of data)
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						
						//Writes the specific object to the OOS
						oos.writeObject(courses);
						
						//Close both streams
						oos.close();
						fos.close();
						System.out.println("Serialization complete");
					} 
					catch (IOException ioe) {
						ioe.printStackTrace();
					}
					
			}
					//Student serializedStudent = new Student(file, file, file, file);
					//Student duh = null;
			public void serializeStudents() {
					try {
		//FileOutput Stream writes data to a file
						FileOutputStream fosh = new FileOutputStream("students.ser");
		
		//ObjectOutputStream writes objects to a stream (A sequence of data)
						ObjectOutputStream oosh = new ObjectOutputStream(fosh);
		
		//Writes the specific object to the OOS
						oosh.writeObject(students);
		
		//Close both streams
						oosh.close();
						fosh.close();
						System.out.println("Serialization complete");
					} 
					catch (IOException ioe) {
						ioe.printStackTrace();
					}
			}**/
			
			
	}
	
	
	public static void serializeCourses(ArrayList<Course> courses) {
		try {
			//FileOutput Stream writes data to a file
			FileOutputStream fos = new FileOutputStream("UniversityCourses.ser");
			
			//ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//Writes the specific object to the OOS
			oos.writeObject(courses);
			
			//Close both streams
			oos.close();
			fos.close();
			//System.out.println("Serialization complete");
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
}
		//Student serializedStudent = new Student(file, file, file, file);
		//Student duh = null;
public static void serializeStudents(ArrayList<Student> students) {
		try {
//FileOutput Stream writes data to a file
			FileOutputStream fosh = new FileOutputStream("students.ser");

//ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oosh = new ObjectOutputStream(fosh);

//Writes the specific object to the OOS
			oosh.writeObject(students);

//Close both streams
			oosh.close();
			fosh.close();
			//System.out.println("Serialization complete");
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
}
	
	
	
	
}