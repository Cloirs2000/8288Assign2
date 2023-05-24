/* 
 *  Student Name :  Chang Liu
 *  Student Number: 040919803
 *  Professor: Howard Rosenblum
 *  Assignment: CST8116 - 313, Assignment 1
 *  Due Date: June 17,2022
 *  Description: Sample Solution Assignment 1 (22S)
 *  
 * */

// Table class for calculating how many table-tops can be varnished by using one can varnish.
public class Table {
	
	private double diameter;
	private int num;    // number of coats is named ¡°num¡± , it's the number of how many coats for per table-top
	private int area = 46800;       //  set a constant named ¡°area¡±, it¡¯s the total area that one can varnish can paint

	
	// constructor, with diameter and the number of how many coat layers need to be varnished on one table-top.
	public Table(double diameter, int num) {
    	this.diameter = diameter;
    	this.num = num;
    }
	
	//  accessor for diameter
	public double getDiameter() {
		return diameter;
	}
	
	
	//mutator for diameter
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	
	// accessor for num
	public int getNum() {
		return num;
	}
	
	// mutator for num
	public void setNum(int num) {
		this.num = num;
	}
	
	//  mathematical formula for calculating the area of table-top.  area of circle= ¦Ð * square of r. 
	
	public double circleArea() {
		double circleArea;
		circleArea = Math.PI * Math.pow(diameter/2, 2);
		return circleArea;
	}
	
	// the final result = total area that can be varnished by using one can / (table-top area*coat layers per table-top)
	public double result() {
		double result;
		result = area / (circleArea() * num); 
		return result; 
	}

}
