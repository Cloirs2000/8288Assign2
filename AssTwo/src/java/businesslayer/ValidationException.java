
/*
Student Name: Chang Liu
Student Number: 040919803
Course & Section #: 22S_CST8288_020
Declaration:
This is the Assignment 2 of CST8288. 
It represents how to use Servlet with a connection to the database using JDBC.
*/
package businesslayer;

/**
 * This exception is thrown when the data provided is not in valid format during validation.
 * 
 * @author Cloris
 * @see ValidationException
 * @since 1.0
 * @version 1.0
 */
public class ValidationException extends Exception {
	
	public ValidationException(){
		super("Data not in valid format");
	}
	
	public ValidationException(String message){
		super(message);
	}
	
	public ValidationException(String message, Throwable throwable){
		super(message, throwable);
	}
	
	public ValidationException(Throwable throwable){
		super(throwable);
	}
}
