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
 * a DTO used to store and transfer DBMS login credentials
 * between businesslayer and dataacesslayer
 * 
 * @author Cloris
 * @see CredentialsDTO
 * @version 1.0
 * @since  1.0
 */

public class CredentialsDTO {
    private String username;
    private String password;

    /**
     * simple getter for user name portion of the credentials
     * @return user name portion of the credentials
     */
    public String getUsername() {
        return username;
    }

    /**
     * simple setter for user name portion of the credentials
     * @param username user name portion of the credentials
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * simple getter for password portion of the credentials
     * @return password portion of the credentials
     */
    public String getPassword() {
        return password;
    }

    /**
     * simple setter for password portion of the credentials
     * @param password password portion of the credentials
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
