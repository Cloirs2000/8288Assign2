// standard Algonquin header goes here.

/*
Student Name: Chang Liu 
Student Number: 040919803
Course & Section #: 22S_CST8288_020 Lab 023
Declaration:
Class FCconverter represents an instant method to converter a number in Fahrenheit to Celsius.
*/
package pkgUnitConverter;
/**
 * class to convert Fahrenheit to Celsius
 * @author Chang Liu
 * @version 1.0
 * @see FCconverter
 */
public class FCconverter implements Converter{
	private final double convFactor=1.8;
	private final double convOrigin=32.0;

        /**
         * 
         * @param convertedNum  the value in Fahrenheit which need to be converted into Celsius.
         * @return  the result after converted
         */            
        @Override
	public double convert(double convertedNum) {
          
            return (convertedNum - convOrigin)/convFactor;
	}
}
