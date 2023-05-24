/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/*
Student Name: Chang Liu 
Student Number: 040919803
Course & Section #: 22S_CST8288_020 Lab 023
Declaration:
Class UnitConverter is an environment class in the Strategy pattern.
*/
package pkgUnitConverter;

/**
 * This class represents the "context" in the Strategy Design Pattern
 * 
 * @author Cloris
 * @version 1.0
 * @see UnitConverter
 */
public class UnitConverter {
    private Converter converter;

    public UnitConverter(){
        this.converter = new FCconverter();
    }
    /**
     * 
     * @param convertedNum
     * @return 
     */
    public double executeConverter(double convertedNum){
         return  converter.convert(convertedNum);
    }
    
   
}
 