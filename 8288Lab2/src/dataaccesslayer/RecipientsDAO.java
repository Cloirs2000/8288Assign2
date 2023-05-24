/*
Student Name: Chang Liu 
Student Number: 040919803
Course & Section #: 22S_CST8288_020 Lab 023
Declaration:
CST8288 Lab2.  Demonstration of DAO Design Pattern.
*/
package dataaccesslayer;

import java.util.List;

import transferobjects.RecipientsDTO;

/**
 * The RecipientsDAO interface defines the methods for performing CRUD operations on recipients data.
 * @author Cloris
 * @since 1.0
 * @version 1.0
 * @see RecipientsDAO
 */
public interface RecipientsDAO {
    /**
     * Returns a list of all recipients.
     * @return   a list of RecipientsDTO objects
     */
    List<RecipientsDTO> getAllRecipients();
    
    /**
     * Returns the RecipientsDTO object corresponding to the given award ID.
     * @param awardID    the name of the column recipients ID in database table
     * @return   the RecipientsDTO object corresponding to the given award ID, or null if no match is found
     */
    RecipientsDTO getRecipientsByAwardId(Integer awardID);
    void addRecipient(RecipientsDTO recipient);
    void updateRecipient(RecipientsDTO recipient);
    void deleteRecipient(RecipientsDTO recipient);
    
}
