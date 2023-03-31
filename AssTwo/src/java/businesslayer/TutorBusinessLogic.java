
/*
Student Name: Chang Liu
Student Number: 040919803
Course & Section #: 22S_CST8288_020
Declaration:
This is the Assignment 2 of CST8288. 
It represents how to use Servlet with a connection to the database using JDBC.
*/
package businesslayer;

import dataaccesslayer.TutorDAO;
import dataaccesslayer.TutorDaoImpl;
import java.util.List;
import transferobjects.CredentialsDTO;
import transferobjects.TutorDTO;

/** 
 * The TutorBusinessLogic class contains the business logic methods for managing tutors in the tutoring application.
 *
 * @author Cloris
 * @see TutorBusinessLogic
 * @version 1.0
 * @since 1.0
 */
public class TutorBusinessLogic {
    private TutorDAO tutorDao = null;
    private CredentialsDTO creds;

    private static final int FIRST_NAME_MAX_LENGTH = 45;
    private static final int LAST_NAME_MAX_LENGTH = 45;

    /**
     * Constructs a new TutorBusinessLogic object with the specified credentials.
     * @param creds    the credentials for accessing the database
     * 
     */
    public TutorBusinessLogic (CredentialsDTO creds){
            tutorDao = new TutorDaoImpl(creds);
    }

    /**
     * Retrieves a list of all tutors.
     * @return a TutorDTO object representing all tutors
     * 
     */
    public List<TutorDTO> getAllTutors(){
        return tutorDao.getAllTutors();
    }
    
    /**
     * Checks the grade for the specified tutor.
     * @param lastName    last name of the tutor
     * @param firstName     first name of the tutor
     * @return  the grade of the tutor as a string
     */
    public String checkGrade(String lastName, String firstName){

        return tutorDao.checkGrade(lastName, firstName);
    }

    /**
     * 
     * @param lastName    last name of the tutor
     * @param firstName     first name of the tutor
     * @return the tutorId of a tutor as a integer
     */
    public Integer checkRegister(String lastName, String firstName){
        return tutorDao.checkRegister(lastName, firstName);
    }
    
    /**
     * Adds the specified tutor to the tutorcourse table.
     * @param tutor  the TutorDTO object representing the tutor to be added
     * @param courseCode     the course code for the tutorcourse record
     * @throws ValidationException   if the tutor data is not in a valid format
     */
    public void addTutorToTutorcourseTable(TutorDTO tutor, String courseCode) throws ValidationException{

        tutorDao.addTutorToTutorcourseTable(tutor, courseCode);
       
    }
        
    /**
     * Cleans the specified tutor object by trimming whitespace from the first name and last name fields.
     * @param tutor   the TutorDTO object to be cleaned
     */
    private void cleanTutor(TutorDTO tutor){
		if(tutor.getFirstName() != null){ 
			tutor.setFirstName(tutor.getFirstName().trim());
		}
		if(tutor.getLastName() != null){ 
			tutor.setLastName(tutor.getLastName().trim());
		}
	}
	
    /**
     * Validates the specified TutorDTO object by checking the length and nullability of the first name and last name fields.
     * @param tutor  the TutorDTO object to be validated
     * @throws ValidationException if the tutor data is not in a valid format
     */
    private void validateTutor(TutorDTO tutor) throws ValidationException{
            validateString(tutor.getFirstName(), "FirstName", FIRST_NAME_MAX_LENGTH, true);
            validateString(tutor.getLastName(), "LastName", LAST_NAME_MAX_LENGTH, true);
    }

    /**
     * Validates the specified string by checking its length and nullability.
     * @param value the string value to be validated
     * @param fieldName the name of the field being validated
     * @param maxLength the maximum length allowed for the field
     * @param isNullAllowed whether null values are allowed for the field
     * @throws ValidationException if the string value is not in a valid format
     */
    private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
        throws ValidationException{
            if(value == null && isNullAllowed){
                    // return; // null permitted, nothing to validate
            }
            else if(value == null && ! isNullAllowed){
                throw new ValidationException(String.format("%s cannot be null", 
                            fieldName));
            }
            else if(value.length() == 0){
                    throw new ValidationException(String.format("%s cannot be empty or only whitespace", 
                                    fieldName));
            }
            else if(value.length() > maxLength){
                    throw new ValidationException(String.format("%s cannot exceed %d characters", 
                                    fieldName, maxLength));
            }
    }


}
