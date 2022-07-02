package assignment2;
import java.sql.*; 
import java.util.Scanner;

/* Name: IZZAT HAKIMI BIN IKMAL HISHAM*/
/* Matric number: 208335      */


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		// Create a view
		Student_UI view = new Student_UI();
		
		
		System.out.print("1. Input Marks \n2. Check Student's Mark \nSelect: ");
		int option = input.nextInt();
		
		//display different view base on the option
		view.displayMenu(option);
		
	
	}
}