
/*
Student Name: Chang Liu
Student Number: 040919803
Course & Section #: 22S_CST8288_020
Declaration:
This is the Assignment 2 of CST8288. 
It represents how to use Servlet with a connection to the database using JDBC.
*/

package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import transferobjects.CredentialsDTO;

/**
 * The DataSource class provides a connection to a MySQL database, It is used to manage the connection
 * to the database and to perform database operations, This class takes a CredentialsDTO object to establish
 * a connection to the database.
 *
 * @author Cloris
 * @see DataSource
 * @since 1.0
 * @version 1.0
 */
public class DataSource {
    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/tutoring?useSSL=false&allowPublicKeyRetrieval=true";

    private String username;
    private String password;

    public DataSource(CredentialsDTO creds) {
        username=creds.getUsername();
        password=creds.getPassword();
    }

/**
 * Creates a new connection to the database and returns it, If a connection already exists, this method 
 * will print a message to the console indicating that a new connection cannot be created.
 * 
 * @return connection   a Connection object representing the connection to the database
 */
    public Connection createConnection() {
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
    
}
