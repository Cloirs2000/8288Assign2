/*
Student Name: Chang Liu 
Student Number: 040919803
Course & Section #: 22S_CST8288_020 Lab 023
Declaration:
CST8288 Lab2.  Demonstration of DAO Design Pattern.
*/
package businesslayer;

/**
 * Custom exception class for validation errors
 * This exception can be thrown when data is not in a valid format,
 * It extends the Exception class and provides several constructors to handle different types of exceptions.
 * @author Cloris
 * @since 1.0
 * @version 1.0
 * @see ValidationException
 */
public class ValidationException extends Exception{
    
        /**
         * Constructs a ValidationException with the default error message
         */
        public ValidationException(){
		super("Data not in valid format");
	}
	
        /**
         * Constructs a ValidationException with the specified error message.
         * @param message    the error message
         */
	public ValidationException(String message){
		super(message);
	}
	
        /**
         * Constructs a ValidationException with the specified error message and cause.
         * @param message      the error message
         * @param throwable    the cause of the exception
         */
	public ValidationException(String message, Throwable throwable){
		super(message, throwable);
	}
	
        /**
         * Constructs a ValidationException with the specified cause.
         * @param throwable    the cause of the exception
         */
	public ValidationException(Throwable throwable){
		super(throwable);
	}
}
