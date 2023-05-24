/*
Student Name: Chang Liu 
Student Number: 040919803
Course & Section #: 22S_CST8288_020 Lab 023
Declaration:
CST8288 Lab2.  Demonstration of DAO Design Pattern.
*/

import businesslayer.RecipientsBusinessLogic;
import businesslayer.ValidationException;
import transferobjects.RecipientsDTO;

import java.util.List;

/**
 * The SimpleDemo class is a demonstration of using the RecipientsBusinessLogic
 * to interact with a recipient data table.
 *
 * @author Cloris
 * @since 1.0
 * @version 1.0
 * @see SimpleDemo
 */
public class SimpleDemo {
    

    public void demo(){
        try{    
                // create a new instance of the RecipientsBusinessLogic class
                RecipientsBusinessLogic logic = new RecipientsBusinessLogic();
                
                // initialize variables for the list of recipients and a single recipient
                List<RecipientsDTO> list = null;
                RecipientsDTO recipient = null;
                // print all the recipients in the data table
                System.out.println("Printing Recipients Table");
                list = logic.getAllRecipients();
                printRecipients(list);
                
                // print a single recipient from the data table using its primary key
                System.out.println("Printing One Record");
                recipient = logic.getRecipients(1);
                printRecipient(recipient);
                System.out.println();
                
                // print the inserted new recipient into the table
                System.out.println("Inserting One Record");
                recipient = new RecipientsDTO();
                recipient.setName("FirstTestAdd");
                recipient.setYear("2023");
                recipient.setCity("Ottawa");
                recipient.setCategory("insertCategory");
                logic.addRecipient(recipient);
                list = logic.getAllRecipients();
                printRecipients(list);
            //  updated recipient record into the table then print table
                System.out.println("Updating last record");
                Integer updatePrimaryKey = list.get(list.size() - 1).getAwardID();
                recipient = new RecipientsDTO();
                recipient.setAwardID(updatePrimaryKey);
                recipient.setName("FirstTestUpdate");
                recipient.setYear("2023");
                recipient.setCity("Ottawa");
                recipient.setCategory("updateCategory");              
                logic.updateRecipient(recipient);
                list = logic.getAllRecipients();
                printRecipients(list);
                
                // print the table after delete the last record
                System.out.println("Deleting last record");
                recipient = list.get(list.size() - 1);
                logic.deleteRecipient(recipient);
                list = logic.getAllRecipients();
                printRecipients(list);	
        }
        catch(ValidationException e){
                System.err.println(e.getMessage());
        }
    }
	/**
         * Prints a single recipient to the console in a formatted manner.
         * @param recipient    the recipient to be printed
         */
	private static void printRecipient(RecipientsDTO recipient){
	    	String output = String.format("%4s    %-30s\t %4s\t %12s\t %s\t",
                            recipient.getAwardID().toString(),
                            recipient.getName(),
                            recipient.getYear(),
                            recipient.getCity(),
                            recipient.getCategory()
                );
	    	System.out.println(output);
                
	}
	
        /**
         * Prints a list of recipients to the console by calling printRecipient on each recipient in the list.
         * @param recipients the list of recipients to be printed
         */
	private static void printRecipients(List<RecipientsDTO> recipients){
	    for(RecipientsDTO recipient : recipients){
	    	printRecipient(recipient);
	    }
	    System.out.println();
	}
    
}
