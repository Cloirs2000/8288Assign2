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

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * RecipientsDaoImpl implements RecipientsDAO class, It is used to interact with a database table called Recipients,
 * which presumably stores data about award recipients,
 * The class contains four methods that implement the interface methods.
 * @author Cloris
 * @since 1.0
 * @version 1.0
 * @see RecipientsDaoImpl
 */
public class RecipientsDaoImpl implements RecipientsDAO{
    
    /**
     * The getAllRecipients method retrieves 
     * all recipients from the Recipients table and returns them as a list of RecipientsDTO objects,
     * It also prints information about the columns in the Recipients table to the console.
     * @return recipients
     */
    @Override
    public List<RecipientsDTO> getAllRecipients(){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<RecipientsDTO> recipients = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("SELECT AwardID, Name, Year, City, Category FROM recipients ORDER BY AwardID");
            rs = pstmt.executeQuery();
            recipients = new ArrayList<RecipientsDTO>();
            while(rs.next()){
                RecipientsDTO recipient = new RecipientsDTO();
                recipient.setAwardID(rs.getInt("AwardID"));
                recipient.setName(rs.getString("Name"));
                recipient.setYear(rs.getString("Year"));
                recipient.setCity(rs.getString("City"));
                recipient.setCategory(rs.getString("Category"));
                recipients.add(recipient);
            } 
         // process query results
         ResultSetMetaData metaData = rs.getMetaData();
         int numberOfColumns = metaData.getColumnCount();     
      //   System.out.println( "Printing Recipients Table:" );
         
         System.out.println( "\nRecipients Table - Column Attributes:" );
         
         for ( int i = 1; i <= numberOfColumns; i++ ) {
            System.out.printf( "%-8s\t", metaData.getColumnName( i ) );
            System.out.printf( "%-8s\t", metaData.getColumnTypeName(i) );
            System.out.printf( "%-8s\t", metaData.getColumnClassName(i) );
            System.out.printf("\n");
         }
        System.out.println();
         
     
                  //print out column names with format   
         for ( int i = 1; i <= numberOfColumns; i++ ){
             switch (i){
                 case 1:
                     System.out.printf( "%-8s\t", metaData.getColumnName( i ) );
                     break;
                 case 2:
                     System.out.printf( "%-30s\t", metaData.getColumnName( i ) );
                     break;
                 case 3:
                     System.out.printf( "%-8s\t", metaData.getColumnName( i ) );
                     break;
                 case 4:
                     System.out.printf( "%-8s\t", metaData.getColumnName( i ) );
                     break;
                 case 5:
                     System.out.printf( "%-8s\t", metaData.getColumnName( i ) );
                     break;
             }
             
         }
          System.out.println();
             
    
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(rs != null){ rs.close();        }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            
            try{
                if(pstmt != null) {   pstmt.close();    } 
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
            
            try{
                if(con != null) {  con.close();    }
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            
        }
        return recipients;
    }
    /**
     * The getRecipientByAwardId method retrieves a single recipient 
     * from the Recipients table by their award ID, which is passed as a parameter.
     * 
     * @param awardID
     * @return recipient
     */
    @Override
    public RecipientsDTO getRecipientsByAwardId(Integer awardID){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        RecipientsDTO recipient = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("SELECT AwardID, Name, Year, City, Category FROM recipients WHERE AwardID = ?");
            pstmt.setInt(1, awardID.intValue());
            rs = pstmt.executeQuery();
            while(rs.next()){
                recipient = new RecipientsDTO();
                recipient.setAwardID(rs.getInt("AwardID"));
                recipient.setName(rs.getString("Name"));
                recipient.setYear(rs.getString("Year"));
                recipient.setCity(rs.getString("City"));
                recipient.setCategory(rs.getString("Category"));
            }        
   
        } catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(rs != null){ rs.close();        }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            
            try{
                if(pstmt != null) {   pstmt.close();    }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
            
            try{
                if(con != null) {  con.close();    }
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return recipient;    
    }
    /**
     * The addRecipient method adds a new recipient to the Recipients table, using a RecipientsDTO object as the input.
     * 
     * @param recipient 
     */
    @Override
    public void addRecipient(RecipientsDTO recipient){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
       
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("INSERT INTO Recipients (Name, Year, City, Category)" + "VALUE(?,?,?,?)");
            pstmt.setString(1, recipient.getName());
            pstmt.setString(2, recipient.getYear());
            pstmt.setString(3, recipient.getCity());
            pstmt.setString(4, recipient.getCategory());
            pstmt.executeUpdate();

        }
         catch(SQLException e){
           e.printStackTrace();
        }
        finally{
            try{
                if(pstmt != null){   pstmt.close();   }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            
            try{
                if(con != null){   pstmt.close();         }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * The updateRecipient method updates the data for a recipient 
     * in the Recipients table using a RecipientsDTO object as input.
     * 
     * @param recipient 
     */
    @Override
    public void updateRecipient (RecipientsDTO recipient){
        Connection con = null;
        PreparedStatement pstmt = null;
    //    ResultSet rs = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("UPDATE Recipients SET Name=?,Year=?, City=?, Category=? WHERE AwardID=?");
            pstmt.setString(1, recipient.getName());
            pstmt.setString(2, recipient.getYear());
            pstmt.setString(3, recipient.getCity());
            pstmt.setString(4, recipient.getCategory());
            pstmt.setInt(5, recipient.getAwardID());
            pstmt.executeUpdate();
   

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(pstmt != null){   pstmt.close();         }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            
            try{
                if(con != null){   pstmt.close();         }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * The class creates a database connection, prepares SQL statements, 
     * and executes queries using a DataSource object, It also handles closing 
     * connections, statements, and result sets.
     * 
     * @param recipient 
     */
    @Override
    public void deleteRecipient(RecipientsDTO recipient){
        Connection con = null;
        PreparedStatement pstmt = null;
  //      ResultSet rs = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("DELETE FROM Recipients WHERE AwardID=?");
            pstmt.setInt(1, recipient.getAwardID().intValue());
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(pstmt != null){   pstmt.close();       }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            
            try{
                if(con != null){   pstmt.close();         }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
