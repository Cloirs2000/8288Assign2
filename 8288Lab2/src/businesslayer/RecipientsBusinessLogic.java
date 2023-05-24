/*
Student Name: Chang Liu 
Student Number: 040919803
Course & Section #: 22S_CST8288_020 Lab 023
Declaration:
CST8288 Lab2.  Demonstration of DAO Design Pattern.
*/
package businesslayer;

import java.util.List;
import dataaccesslayer.RecipientsDAO;
import dataaccesslayer.RecipientsDaoImpl;
import transferobjects.RecipientsDTO;

/**
 * The RecipientsBusinessLogic class provides business logic methods for interacting with the recipients data,
 * It contains methods for adding, updating, deleting, and retrieving recipients, as well as for validating recipient data.
 * @author Cloris
 * @since 1.0
 * @version 1.0
 * @see RecipientsBusinessLogic
 */
public class RecipientsBusinessLogic {
    private static final int NAME_MAX_LENGTH = 40;
    private static final int CITY_MAX_LENGTH = 30;
    private static final int CATEGORY_MAX_LENGTH =40;

    private RecipientsDAO recipientsDao = null;

     /**
      * Constructs a new instance of RecipientsBusinessLogic and initializes its RecipientsDAO.
      */
    public RecipientsBusinessLogic(){
            recipientsDao = new RecipientsDaoImpl();
    }
    /**
     * Retrieves all recipients from the recipientsDao.
     * @return    a List of RecipientsDTO objects representing all recipients.
     */
    public List<RecipientsDTO> getAllRecipients(){
            return recipientsDao.getAllRecipients();
    }
    
    /**
     * Retrieves a recipient by its awardID.
     * @param awardID   the AwardID of recipients database table that the recipient to retrieve
     * @return   a RecipientsDTO object representing the retrieved recipient
     */
    public RecipientsDTO getRecipients(Integer awardID){
            return recipientsDao.getRecipientsByAwardId(awardID);
    }
    
    /**
     * Adds a new recipient to the recipientsDao.
     * @param recipient           the RecipientsDTO object representing the recipient to add
     * @throws ValidationException     if the recipient data is not valid
     */
    public void addRecipient(RecipientsDTO recipient) throws ValidationException{
            cleanRecipient(recipient);
            validateRecipient(recipient);
            recipientsDao.addRecipient(recipient);
    }
    
    /**
     * Updates an existing recipient in the recipientsDao.
     * @param recipient     the RecipientsDTO object representing the recipient to update
     * @throws ValidationException    if the recipient data is not valid
     */
    public void updateRecipient(RecipientsDTO recipient) throws ValidationException{
            cleanRecipient(recipient);
            validateRecipient(recipient);
            recipientsDao.updateRecipient(recipient);
    }
    
    /**
     * Deletes a recipient from the recipientsDao.
     * @param recipient    the RecipientsDTO object representing the recipient to delete
     */
    public void deleteRecipient(RecipientsDTO recipient){
            recipientsDao.deleteRecipient(recipient);
    }
    
    /**
     * Execute cleanRecipient depending on the IF judging condition
     * @param recipient   the RecipientsDTO object to clean
     */
    private void cleanRecipient(RecipientsDTO recipient){
            if(recipient.getName() != null){ 
                    recipient.setName(recipient.getName().trim());
            }
            if(recipient.getYear() != null){ 
                    recipient.setYear(recipient.getYear().trim());
            }
            if(recipient.getCity() != null){ 
                    recipient.setCity(recipient.getCity().trim());
            }
            if(recipient.getCategory() != null){ 
                    recipient.setCategory(recipient.getCategory().trim());
            }
            
    }
    
    /**
     * Validates the Name City and Category date.
     * @param recipient     the RecipientsDTO object to validate
     * @throws ValidationException    print out related info if any recipient data is not valid
     */
    private void validateRecipient(RecipientsDTO recipient) throws ValidationException{
            validateString(recipient.getName(), "Name", NAME_MAX_LENGTH, true);
            validateString(recipient.getCity(), "City", CITY_MAX_LENGTH, true);
            validateString(recipient.getCity(), "Category", CATEGORY_MAX_LENGTH, true);
    }

        /**
         * Validates the value of each filed that input into the database table
         * @param value          the data of a cell
         * @param fieldName       column name of the table
         * @param maxLength       the max length of the field
         * @param isNullAllowed   the limitation of the field of table can not be null
         * @throws ValidationException   print out related info if any recipient data is not valid
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
