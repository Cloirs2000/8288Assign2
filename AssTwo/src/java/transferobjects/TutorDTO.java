/*
Student Name: Chang Liu
Student Number: 040919803
Course & Section #: 22S_CST8288_020
Declaration:
This is the Assignment 2 of CST8288. 
It represents how to use Servlet with a connection to the database using JDBC.
*/
package transferobjects;

/**
 * The TutorDTO class represents a Data Transfer Object (DTO) that contains information about a tutor,
 * This class has fields for the tutor's first name, last name, and tutor ID.
 * 
 * @author Cloris
 * @see TutorDTO
 * @version 1.0
 * @since  1.0
 */
public class TutorDTO {
    private String firstName;
    private String lastName;
    private Integer tutorId;
    
    public TutorDTO(){
    
    }
    
    /**
     * overloaded constructor
     * 
     * @param tutorId   tutor's id it the person has registered as a tutor
     * @param firstName tutor's first name
     * @param lastName tutor's last name
     */
    public TutorDTO(Integer tutorId, String firstName, String lastName){
        this.tutorId = tutorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public Integer getTutorId(){
        return tutorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    public void setTutorId(Integer tutorId){
        this.tutorId = tutorId;
    }
    

    
    
}
