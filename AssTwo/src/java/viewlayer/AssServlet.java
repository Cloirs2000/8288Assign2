/*
Student Name: Chang Liu
Student Number: 040919803
Course & Section #: 22S_CST8288_020
Declaration:
This is the Assignment 2 of CST8288. 
It represents how to use Servlet with a connection to the database using JDBC.
*/
package viewlayer;

import businesslayer.TutorBusinessLogic;
import businesslayer.ValidationException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.CredentialsDTO;
import transferobjects.TutorDTO;
import dataaccesslayer.TutorDAO;
import dataaccesslayer.TutorDaoImpl;
import dataaccesslayer.DataSource;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
        

/**
 * Demonstration of DAO Design Pattern with Servlet website
 *
 * @author Cloris
 * @see AssServlet
 * @version 1.0
 * @since  1.0
 */
public class AssServlet extends HttpServlet {
    private CredentialsDTO creds=new CredentialsDTO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    creds.setUsername(request.getParameter("username"));
                    creds.setPassword(request.getParameter("password"));
                    
                   
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Assignment 2 Servlet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<center>");
                    out.println("<h1>Servlet SampleFormServlet </h1>");


                    TutorBusinessLogic logic = new TutorBusinessLogic(creds);
                    List<TutorDTO> authors = null;
                    String lastName = request.getParameter("lastName");
                    String firstName =request.getParameter("firstName");
                    String courseCode = request.getParameter("courseCode");
                    
                    Integer tutorIdResult =null;
                    tutorIdResult= logic.checkRegister(lastName, firstName);
                    
                    String gradeResult=null;
                    gradeResult = logic.checkGrade(lastName, firstName);

                    TutorDTO tutor = new TutorDTO(tutorIdResult, lastName, firstName);
                    
          // determind if a person has registed as a tutor. If tutorIdResult is not null, that means the person has been in the databaes
                        if (tutorIdResult == null ){

                            out.println("<p><b>Last Name: </b>" + lastName+ "</p>");

                            out.println("<p><b>First Name: </b>"+ firstName+"</p>");
                    
                            out.println("<p>The person has not registered as a tutor </p>");
                          
                        } 
        // determind if the grade of a person is qualified to be a tutor. 
                        else if (gradeResult.equals("A+") || gradeResult.equals("A")||gradeResult.equals("A+")){
                                logic.addTutorToTutorcourseTable(tutor, courseCode);
                                authors = logic.getAllTutors();
                                out.println("<p>Table of Tutors assigned to CST8101 </p>");
                                out.println("<table border=\"1\">");
                                 
                                out.println("<tr>");
                                out.println("<td>Tutor ID</td>");
                                out.println("<td>Last Name</td>");
                                out.println("<td>First Name</td>");
                                out.println("</tr>");
                                for(TutorDTO author : authors){
                                    out.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>",
                                        author.getTutorId(), author.getLastName(), author.getFirstName());
                                }
                                out.println("</table>");

                            } else{

                            out.println("<p><b>Last Name: </b>" + lastName+ "</p>");
 
                            out.println("<p><b>First Name: </b>"+ firstName+"</p>");
                            out.println("<p>The person does not qualify to tutor this course as the obtained grade is not sufficient </p>");

                            }
                out.println("</center>");
                out.println("</body>");
                out.println("</html>");  
                
        
                } catch (ValidationException ex) {
            Logger.getLogger(AssServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
      // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold> 
    
}
