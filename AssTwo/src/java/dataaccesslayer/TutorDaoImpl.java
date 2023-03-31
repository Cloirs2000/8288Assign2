
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import transferobjects.CredentialsDTO;
import transferobjects.TutorDTO;

/**
 * Implementation of the TutorDAO interface that provides methods for accessing and manipulating tutor data in a database,
 * This implementation uses a DataSource object to establish a connection to the database 
 * using the credentials provided in the constructor.
 *
 * @author Cloris
 * @see TutorDaoImpl
 * @since 1.0
 * @version 1.0
 *  
 */
public class TutorDaoImpl implements TutorDAO {
    
    private CredentialsDTO creds;

    /**
     * Constructs a TutorDaoImpl object with the specified 
     * CredentialsDTO object that contains the database login credentials.
     * @param creds the CredentialsDTO object that contains the database login credentials
     */
    public TutorDaoImpl(CredentialsDTO creds) {
        this.creds = creds;
    }


/**
 * Returns a list of all the tutors who have taught a course with a grade of A, A-, or A+.
 * @return  tutors    a list of TutorDTO objects representing the tutors who have taught a course with a grade of A, A-, or A+
 */
    @Override
    public List<TutorDTO> getAllTutors() {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<TutorDTO> tutors = null;
            try{
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                "SELECT distinct(tutor.TutorID), tutor.LastName, tutor.FirstName FROM tutor " +
                "left join tutorcourse on tutorcourse.tutor_TutorID=tutor.TutorID " +
                "left join course on tutorcourse.course_CourseCode = course.CourseCode " +
                "left join grade on course.CourseCode=grade.course_CourseCode " +
                "where grade.GradeCode ='A-'or grade.GradeCode ='A'or grade.GradeCode ='A+'");
            rs = pstmt.executeQuery();
            tutors = new ArrayList<TutorDTO>();
            while(rs.next()){
                    TutorDTO tutor = new TutorDTO();
                    tutor.setTutorId(rs.getInt("TutorID"));
                    tutor.setLastName(rs.getString("LastName"));
                    tutor.setFirstName(rs.getString("FirstName"));

                    tutors.add(tutor);
            }
        }
        catch(SQLException e){
                e.printStackTrace();
        }
        finally{
                try{ if(rs != null){ rs.close(); } }
                catch(SQLException ex){System.out.println(ex.getMessage());}
                try{ if(pstmt != null){ pstmt.close(); }}
                catch(SQLException ex){System.out.println(ex.getMessage());}
                try{ if(con != null){ con.close(); }}
                catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return tutors; 
       
    }



    /**
     * Returns the grade code for the student with the specified first and last name.
     * @param lastName   the last name of the student
     * @param firstName   the first name of the student
     * @return gradeCode    the grade code for the student with the specified first and last name
     * 
     * 
     */
    @Override
    public String checkGrade(String lastName, String firstName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        TutorDTO tutor = null;
        String gradeCode= null;

        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
      
            pstmt = con.prepareStatement("SELECT GradeCode FROM student join grade " +
                    "on student.StudentID = grade.student_StudentID WHERE LastName = ? AND FirstName = ? ");
            pstmt.setString(1, lastName);
            pstmt.setString(2, firstName);

            rs = pstmt.executeQuery();

            while(rs.next())
            {
                gradeCode = rs.getString("GradeCode");
            }
                 
        } catch (SQLException e) {
            e.printStackTrace();
            } 
        finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
 
        return gradeCode;
  
    }
    


    /**
     * Return the tutor id of a student, if the student has registered as a tutor
     * 
     * @param lastName  the last name of the student
     * @param firstName  the first name of the student
     * @return tutor_id    the id of a student is a tutor
     */
    @Override
    public Integer checkRegister(String lastName, String firstName) {
        Connection con = null;
        PreparedStatement pstmt = null;

        ResultSet rs = null;
        Integer tutor_id = null;
        
        try {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            pstmt = con.prepareStatement("SELECT TutorID FROM tutor WHERE LastName = ? AND FirstName = ?");
            pstmt.setString(1, lastName);
            pstmt.setString(2, firstName);
            
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                tutor_id = rs.getInt("TutorID");
            }
        }catch(SQLException e){
             e.printStackTrace();
        }
        finally{
            try{ if(rs != null){ rs.close(); } }
            catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(pstmt != null){ pstmt.close(); }}
            catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(con != null){ con.close(); }}
            catch(SQLException ex){System.out.println(ex.getMessage());}
            
        }
        
    return tutor_id;
    }
    
    /**
     * Add the newly registered tutor into the tutorcourse database table.
     * @param tutor    a tutor object represents who is newly added into the database table
     * @param courseCode the course code of the tutor registered
     */
    @Override
    public void addTutorToTutorcourseTable(TutorDTO tutor, String courseCode){
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try
        {
            DataSource ds = new DataSource(creds);
            con = ds.createConnection();
            String sql = "INSERT INTO tutorcourse (tutor_TutorID, course_CourseCode) VALUES (?, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, tutor.getTutorId());
            pstmt.setString(2, courseCode);
            pstmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
	}
        finally{
            try{ if(pstmt != null){ pstmt.close(); }}
            catch(SQLException ex){System.out.println(ex.getMessage());}
            try{ if(con != null){ con.close(); }}
            catch(SQLException ex){System.out.println(ex.getMessage());}
        }
    }
    
}
