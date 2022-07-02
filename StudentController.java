package assignment2;
/* Name: IZZAT HAKIMI BIN IKMAL HISHAM*/
/* Matric number: 208335      */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.*; 
public class StudentCtrl {
	 private Student model;
     private Student_UI view;
     
     //constructor with model and view arguments
     public StudentCtrl(Student model, Student_UI view){
         this.model = model;
         this.view = view;
      }
     
     // method to retrieve specific student from database
     public void getStudent(int id) throws SQLException{
    	 // create new Student object to hold data
    	 Student stu = new Student();
    	 //Establish connection
    	 String URL = "jdbc:mysql://127.0.0.1:3306/db1?serverTimezone = UTC" ;
	     String Username = "root";
	     String password = "Isaac@207545";
		Connection conn = DriverManager.getConnection(URL, Username, password);
			// SQL statement to retrieve data for specific student with id
 			String sql = "SELECT * FROM STUDENT where StudentID ='" + id +"'";
 			//execute the SQL statement
 			Statement stmt = conn.createStatement();
 			ResultSet rs = stmt.executeQuery(sql);
 			if (rs.next()) {
 				stu.setStudentID(rs.getInt("StudentId"));
 				stu.setStudent_name(rs.getString("Student_name"));
 				stu.setDepartment(rs.getString("Department_name"));
 				stu.setMath_mark(rs.getInt("math_mark"));
 				stu.setScience_mark(rs.getInt("sc_mark"));
 				
 		    } 
 		 // pass the data to view object and display
    	 view.displayStudentMarks(stu.getStudentID(), stu.getStudent_name(), stu.getDepartment(), stu.getMath_mark(), stu.getScience_mark());
     }
     
     // method for user to insert new data into database
     public void inputMarks(int studentId, String name, String department, int math, int science) throws SQLException {
 		
    	 Student stu = new Student();
    	 String URL = "jdbc:mysql://127.0.0.1:3306/db1?serverTimezone = UTC" ;
	     String Username = "root";
	     String password = "Isaac@207545";
		Connection conn = DriverManager.getConnection(URL, Username, password);
  
 			Statement stmt = conn.createStatement();
 			
 		// insert the data into database
 		stmt.executeUpdate("INSERT INTO STUDENT VALUES (" + studentId + ", '"+ name + "', '" +
 		department + "', " + math + ", " + science + ")");
 		
 		System.out.println("Input Sucessfuly!");
 	}
     
}