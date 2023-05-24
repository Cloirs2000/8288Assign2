/*
Student Name: Chang Liu 
Student Number: 040919803
Course & Section #: 22S_CST8288_020 Lab 023
Declaration:
CST8288 Lab2.  Demonstration of DAO Design Pattern.
*/
package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 *The DataSource class is responsible for creating a connection to a database using the database properties stored
 * in the database.properties file,It provides a method to create a connection and returns it,
 * If a connection already exists, it prints a message to the console instead of creating a new connection
 * @author Cloris
 * @since 1.0
 * @version 1.0
 * @see DataSource
 */
public class DataSource {
    private Connection connection = null;
    public DataSource(){}
    
    /**
     * Creates a new database connection using the properties specified in the database.properties file.
     * @return connection    a Connection object representing the database connection
     */
    public Connection createConnection(){
        // added use of Properties and try-with-resources - kriger
        Properties props = new Properties();

            try (InputStream in = Files.newInputStream(Paths.get("src/database.properties"));) {
                    props.load(in);
            } catch (IOException e) {
                    e.printStackTrace();
            }// catch()

        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
            try {
                    if(connection != null){
                            System.out.println("Cannot create new connection, one exists already");
                    }
                    else{
                            connection = DriverManager.getConnection(url, username, password);
                    }
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
        return connection;
    }
    
}
