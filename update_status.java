/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Duggasani Sirisha
 */
@WebServlet(urlPatterns = {"/update_status"})
public class update_status extends HttpServlet {
Statement statement = null;
 static String query = null;
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet update_status</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet update_status at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
         PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        int flag=0;
        String user=request.getParameter("rno");
        if(user.isEmpty() ){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('You must fill rollno ');");
            out.println("location='updatestatus.html';");
            out.println("</script>");
        }
        else{
            try{
            Connection conn=DbConnection.dbConnection();
           // Statement pst=conn.createStatement();
            
             
            
          query = "update student set statuus='Smarty'  where rno='"+user+"';";
executeQuery(query);

           
                 
           if(true){
           out.println("<b>You are successfully updated</b>");
              conn.close();
             }
            
             
             
             
        
    }
        catch(Exception e){
             e.printStackTrace();
        }
        }
    }
     private void executeQuery(String query) {

  try {
   Connection conn=DbConnection.dbConnection();
   statement = conn.createStatement();
   statement.execute(query);

  }
  catch (Exception e) {

   e.printStackTrace();

  }
 } 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    // </editor-fold>

}