
//22F CST8284
//Assignment 1: MyHealthData.java

//This system maintains important health information about a patient.
//Note: This class assumes values passed to the set methods are correct.
// REVIEW THIS FILE AND ASSIGNMENT INSTRUCTIONS CAREFULLY BEFORE YOU START OFF!!


//TO DO 1: INCLUDE YOUR ATTRIBUTES HERE. REMEMBER TO CHECK THE UML CLASS DIAGRAM TO INCLUDE ALL ATTRIBUTES LISTED AND THEIR TYPES.

//START CODE



/**   
 * MyHealthData is the class that is used to calculating patients' Maximum Heart Rate, Target Heart Rate(max and mini) and BMI 
 * that based on the user input data Height and Weight, also asks user input First Name, Last Name, Gender and Birth Year,
 * then auto print out the report that will be showing these info mentioned above.
 *  
 * @see  MyHealthData
 * @author Chang Liu
 * @since 1.0
 * @version 1.0
 */
public class MyHealthData{
	public String firstName;
	public String lastName;
	public String gender;
	public int birthYear;
	public int currentYear;
	public double height;
	public double weight;

//END CODE
	
	
// TO DO 2: INCLUDE YOUR CONSTRUCTOR HERE 
//START CODE
// String firstName, String lastName, String gender, double height, double weight,int birthYear,int currentYear
	
	/**
	 * this is a Constructor.
	 * 
	 * @param firstName  patient's first name
	 * @param lastName   patient's last name
	 * @param gender     patient's gender
	 * @param height     patient's height
	 * @param weight     patient's weight
	 * @param birthYear  patient's birth year
	 * @param currentYear   current year
	 */
	public MyHealthData (String firstName, String lastName, String gender, double height, double weight,int birthYear,int currentYear) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.birthYear = birthYear;
		this.currentYear = currentYear;		 
	}
	
	public MyHealthData () {
		
	}
//END CODE
	
	
	
//TO DO 3: INCLUDE YOUR SET AND GET METHODS HERE. CHECK THE UML CLASS TO ENSURE ALL ARE COMPLETE. SOME ARE ALREADY PROVIDED FOR YOU BELOW.
// THIS RETURNS THE PATIENT'S Body Mass Index (BMI) AND IT IS PROVIDED HERE FOR YOU. DO NOT CHANGE THIS PIECE OF CODE!
	
	/**
	 * Returns patient's first name
	 * @return firstName   patient's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets patient's first name
	 * @param firstName   patient's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 *  Returns patient's last name
	 * @return lastName  patient's last name
	 */ 
	public String getLastName() {
		return lastName;
	}
	
	/**
	 *  Sets patient's last name
	 * @param lastName    patient's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 *  Returns patient's gender
	 * @return gender   patient's gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 *  Sets patient's gender
	 * @param gender    patient's gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 *  Returns patient's birth year
	 * @return birthYear    patient's birth year
	 */
	public int getBirthYear() {
		return birthYear;
	}
	
	/**
	 * Sets patient's birth year
	 * @param birthYear      patient's birth year
	 */
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	/**
	 *  Returns current year
	 * @return     Current year
	 */
	public int getCurrentYear() {
		return currentYear;
	}
	
	/**
	 * Sets current year
	 * @param currentYear     Current year
	 */
	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}
	
	/**
	 *  Returns patient's height
	 * @return height    patient's height
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Sets patient's height
	 * @param height    patient's height
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 *  Returns patient's weight
	 * @return weight    patient's weight
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 *  Sets patient's weight
	 * @param weight    patient's weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	 * Calculate patient's age then returns it
	 * @return age    patient's age`
	 */
	public int getAge() {
		return currentYear - getBirthYear();
	}
	
	/**
	 * Calculate patient's Maximum Heart Rate then returns it
	 * @return maximumHeartRate
	 */
	public double getMaximumHeartRate() {
		return 220 - getAge();
	}
	
	/**
	 * Calculate patient's Minimum Target Heart Rate then returns it
	 * @return minimumTargetRate
	 */
	public double getMinimumTargetHeartRate() {
		return getMaximumHeartRate()/2;
	}
	
	/**
	 * Calculate patient's Maximum Target Heart Rate then returns it
	 * @return maximumTargetHeartRate
	 */
	public double getMaximumTargetHeartRate() {
		return getMaximumHeartRate() * 0.85;
	}
	
	/**
	 * Calculate patient's BMI Rate then returns it
	 * @return BMI
	 */
	public double getBMI() {
	   return (getWeight() * 703) / (getHeight() * getHeight());
	} 
	
	
	// An incorrect method on purpose for showing Junit test failed
	public double getBMI01() {
		   return (getWeight() * 703) - (getHeight() * getHeight());
		} 
		
	// TO DO 4: THIS PORTION OF CODE SHOULD DISPLAY ALL THE PATIENT'S HEALTH DATA. DO NOT MISS ANY DATA / INFORMATION
	
	/**
	 * A method of print out data
	 */
	public void displayMyHealthData() 
	{	
	//TO DO 5: HINT: YOU MUST USE System.out.printf TO SHOW ALL HEALTH DATA. DO NOT MISS ANY ITEM.
	// START CODE
		System.out.println("FirstName  LastName   Gender  BirthYear   Height(inch)    Weight(lb)   Age     MaxHR   MiniTHR   MaxTHR   BMI");
		System.out.printf("%s        %s        %s         %d     %.1f            %.1f        %d      %.1f    %.1f     %.1f   %.1f  %n", 
				firstName, lastName, gender, birthYear, height, weight, getAge(), 
				getMaximumHeartRate(), getMinimumTargetHeartRate(), getMaximumTargetHeartRate(), getBMI() );
		//END CODE
	   
	//DO NOT MODIFY THIS PROTION OF CODE. IT SHOULD PRINT AS IT IS - ALREADY PROVIDED FOR YOU!!
	
	   System.out.println("BMI VALUES");
	   System.out.println("Underweight: less than 18.5");
	   System.out.println("Normal:      between 18.5 and 24.9");
	   System.out.println("Overweight:  between 25 and 29.9");
	   System.out.println("Obese:       30 or greater"); 
	} 
} // end class MyHealthData



