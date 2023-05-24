/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
Student Name: Chang Liu 
Student Number: 040919803
Course & Section #: 22S_CST8288_020 Lab 023
Declaration:
Class InchToCM represents an instant method to converter a number in Inch to CM.
*/

package pkgUnitConverter;

/**
 * The class represents the formula of converter inch to CM 
 * @author Cloris
 * @version 1.0
 * @see InchToCM
 */
public class InchToCM implements Converter{
    
    private final double convFactor = 2.54;
    
    /**
     * 
     * @param convertedNum
     * @return 
     */
    @Override
    public double convert(double convertedNum){
        return convertedNum * convFactor;
    }
    
}
