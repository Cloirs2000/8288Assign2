//standard Algonquin header here

/*
Student Name: Chang Liu 
Student Number: 040919803
Course & Section #: 22S_CST8288_020 Lab 023
Declaration:
Class UnitConveterTest with a main method represents converters between differnet unit types.
*/
package pkgUnitConverterTest;

import pkgUnitConverter.*;
/**
 * simple class to test 2 classes for converting Fahrenheit to Celsius and the reverse, 
 * and another 2 classes for converting Inch to CM and the reverse.
 * @author Chang Liu
 * @version 1.0
 * @see UnitConverterTest
 */
public class UnitConverterTest {

    /**
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

	System.out.println("========== Task 1 ===========");
        UnitConverter unitConverter = new UnitConverter();
        
        System.out.printf("70 in Fahrenheit is %5.2f in Celsius\n", unitConverter.executeConverter(70.0));

        System.out.printf("20 in Celsius is %5.2f in Fahrenheit\n\n", unitConverter.executeConverter(20.0));
        
        System.out.println("========== Task 2 ===========");

        System.out.printf("25 in Inch is %5.2f in CM\n", unitConverter.executeConverter(25.0));
        
        System.out.printf("53 in CM is %5.2f in Inch\n", unitConverter.executeConverter(53.0));
        
	}

}
