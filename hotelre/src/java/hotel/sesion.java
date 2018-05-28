package hotel;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/sesion"})
public class sesion extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //MessageDigest.isEqual(md1, md2)
        
        String str = request.getParameter("uname");
        String str2 = request.getParameter("psw");
        sesionconexion conect = new sesionconexion();
        conect.getConexion();
        System.out.println(conect.toSHA1(str));
        System.out.println(conect.toSHA1(str2));
        PreparedStatement busquedaStmt = null;
        try {
            busquedaStmt = conect.getConexion().prepareStatement("Select * from user where username = ? and password  = ?");
            busquedaStmt.setString(1, conect.toSHA1(str));
            busquedaStmt.setString(2, conect.toSHA1(str2));
            ResultSet rs = busquedaStmt.executeQuery();
            if (rs.next()) {
                
                response.sendRedirect("index.html");
                
            } else {
              response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY); 
              response.setHeader("Location", "http://localhost:8080/login");
              //in this case enter when  result size is zero  it means user is invalid
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String str = request.getParameter("uname");
        String str2 = request.getParameter("psw");

        sesionconexion conect = new sesionconexion();
        conect.getConexion();
        PreparedStatement busquedaStmt = null;
        try {
            busquedaStmt = conect.getConexion().prepareStatement("insert into user (username,password) values (?,?)");
            busquedaStmt.setString(1, conect.toSHA1(str));
            busquedaStmt.setString(2, conect.toSHA1(str2));
            busquedaStmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        //HttpSession session = request.getSession();
        //session.setAttribute("uname", str);
        //session.setAttribute("psw", str2);
        //HttpSession httpSession = request.getSession(false);
//False because we do not want it to create a new session if it does not exist.

//        if (httpSession != null) {
//            httpSession.getAttribute("uname");
//            httpSession.getAttribute("psw");
//
//        }

    }

}
