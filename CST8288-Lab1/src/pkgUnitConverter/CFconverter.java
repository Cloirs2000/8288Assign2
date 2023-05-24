// standard Algonquin header goes here.

/*
Student Name: Chang Liu 
Student Number: 040919803
Course & Section #: 22S_CST8288_020 Lab 023
Declaration:
Class CFconverter represents an instant method to converter a number in Celsius to Fahrenheit.
*/
package pkgUnitConverter;
/**
 * class to convert Celsius to Fahrenheit
 * @author Chang Liu
 * @version 1.0
 * @see CFconverter
 */
public class CFconverter implements Converter {
	private final double convFactor=1.8;
	private final double convOrigin=32.0;

        /**
         * 
         * @param convertedNum  the number Celsius which need to be converted into Fahrenheit.
         * @return   the result after converted
         */
        @Override
	public double convert(double convertedNum) {
            return convertedNum*convFactor + convOrigin;
	}
}
        