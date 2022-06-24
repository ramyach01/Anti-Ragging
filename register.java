
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Duggasani Sirisha
 */
@WebServlet(urlPatterns = {"/register"})
public class register extends HttpServlet {

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
            out.println("<title>Servlet register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        int flag=0;
        String user=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        if(user.isEmpty() || pwd.isEmpty()){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('You must fill both the fields');");
            out.println("location='home.html';");
            out.println("</script>");
        }
        if(user.equals("admin") && pwd.equals("admin")){
            response.sendRedirect("http://localhost:8080/Antiragging/homeadmin.html");
        }
        else{
            try
			{
				Connection conn = DbConnection.dbConnection();
				 Statement stmt = conn.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from student where rno='"+user+"'"); 
             out.println("script type=\"text/javascript\">");
             out.println("<html><body>"); 
             out.println("<table border=1 width=50% height=50%>");  
             out.println("<tr><th>Name</th><th>Rollno</th><th>email</th><th>phone no</th><th>Branch</th><th>text</th><th>Status</th><tr>"); 
             while (rs.next()) 
             {  
                 
                 String n = rs.getString("sname");  
                 String nr = rs.getString("rno");
                 String ne = rs.getString("email");
                 String np = rs.getString("phno");
                 String nb = rs.getString("branch");
                 String nt = rs.getString("ragdetails");
                 String ns = rs.getString("statuus"); 
                 
                 out.println("<tr><td>" + n + "</td><td>" + nr + "</td><td>" + ne + "</td><td>" + np + "</td><td>" + nb + "</td><td>" + nt + "</td><td>" + ns + "</td></tr>");  
                 
             }  
             
             out.println("</table>");  
             
             out.println("</html></body>");
             out.println("location='pendingrequest.html';");
            out.println("</script>");
             
             conn.close();
                                
                }
                     catch(Exception e)
			{
				e.printStackTrace();
			}
        /*else{
            try{
                
            }
        }*/
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
  

}
}