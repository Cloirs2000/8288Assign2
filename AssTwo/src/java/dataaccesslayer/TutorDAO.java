/*
Student Name: Chang Liu
Student Number: 040919803
Course & Section #: 22S_CST8288_020
Declaration:
This is the Assignment 2 of CST8288. 
It represents how to use Servlet with a connection to the database using JDBC.
*/
package dataaccesslayer;

import java.util.List;
import transferobjects.TutorDTO;

/**
 * The TutorDAO interface defines the methods that must be implemented by any class that
 * provides data access for tutors,
 * This interface contains methods to retrieve information about all tutors, check a tutor's grade,
 * check if a tutor is registered, and add a tutor to a tutor course table.
 *
 * @author Cloris
 * @see TutorDAO
 * @version 1.0
 * @since  1.0
 */
public interface TutorDAO {
    
    /**
     * Retrieves a list of all tutors.
     * @return a list of all tutors
     * 
     */
    List<TutorDTO> getAllTutors(); 
    
    /**
     * Checks the grade of a tutor with the given last name and first name.
     * @param lastName the tutor's last name
     * @param firstName the tutor's first name
     * @return a string representation of the tutor's grade
     */
    String checkGrade (String lastName, String firstName);
    
    /**
     * Checks if a tutor with the given last name and first name is registered.
     * @param lastName the tutor's last name
     * @param firstName the tutor's first name
     * @return the tutor's ID if they are registered, null otherwise
     */
    Integer checkRegister (String lastName, String firstName);
    
    /**
     * Adds a tutor to a tutor course table for the given course code.
     * @param tutor the tutor to add to the table
     * @param courseCode the course code of the table to add the tutor to
     */
    void addTutorToTutorcourseTable(TutorDTO tutor, String courseCode);
}
