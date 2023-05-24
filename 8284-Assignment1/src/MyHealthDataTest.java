
import java.time.*;
import java.util.Scanner;


/**
 * MyHeatlthDataTest is a class that contains main method that is used to execute program for the CST8284_Assignment 1.
 * 
 * @author Chang Liu
 * @see MyHealthDataTest
 * @since 1.0
 * @version 1.0
 *
 */
public class MyHealthDataTest {
	
	/**
	 * Contains the program that print out the patient's health data that includes First Name, Last Name, Gender, Birth Year, Age, 
	 * Height, Weight, Maximum Heart Rate, Minimum Target Heart Rate, Maximum Target Heart Rate, and BMI.
	 * @param args   Array of string arguments.
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		String firstName;
		String lastName;
		String gender;
		int birthYear;
		int currentYear = LocalDate.now().getYear();
		double height;
		double weight;
		
		System.out.println("Entry your First Name");
		firstName = keyboard.nextLine();
		
		System.out.println("Entry your Last Name");
		lastName = keyboard.nextLine();
		
		System.out.println("Entry your Gender, F or M");
		gender = keyboard.nextLine();

		System.out.println("Entry your Birth Year");
		birthYear = keyboard.nextInt();
		keyboard.nextLine();
		
		System.out.println("Entry your Height in inchs");
		height = keyboard.nextDouble();
		keyboard.nextLine();
		
		System.out.println("Entry your Weight in pounds");
		weight = keyboard.nextDouble();
		keyboard.nextLine();
		
		MyHealthData healthData = new MyHealthData(firstName, lastName,gender, height, weight, birthYear, currentYear);
		healthData.displayMyHealthData();
	}

}