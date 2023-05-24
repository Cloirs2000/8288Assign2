/* 
 *  Student Name :  Chang Liu
 *  Student Number: 040919803
 *  Professor: Howard Rosenblum
 *  Assignment: CST8116 - 313, Assignment 1
 *  Due Date: June 17,2022
 *  Description: Sample Solution Assignment 1 (22S)
 *  
 * */


import java.util.Scanner;

//  This class contains a main method to run the program
public class CST8116Assignment1 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the Diameter :");
		double diameter = input.nextDouble();
		
		System.out.println("Enter the Number of Coats :");
		int num = input.nextInt();
		
		Table table = new Table(diameter, num);
		
		System.out.println("Tables per one can: " + table.result());
		System.out.println("---------------");
		System.out.println("program implement by Chang Liu");
	
	}

}
