package hotel;

import static hotel.hotercon.con;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class clienteconexion {

    public clienteconexion() {
        System.out.println("ejecutate");
        try {
            //////////////////////////////////////////////////////////////////////////////////////////////      
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/reservas", "root", "root");
            /////////////////////////////////////////////////////////////////////////////////////////////      
        } catch (ClassNotFoundException error1) {
            System.err.println("No se puede cargar JDBC/ODBC");
            System.exit(1);
        } catch (SQLException error2) {
            System.err.println("No se puede conectar a Base de Datos. " + error2);
            System.exit(2);
        }

        //return null;
    }

   

    /////////////////////////////////////////   
    public Connection getConexion() {
        return con;
    }
    /////////////////////////////////////////

    public void closeConexion() {
        try {
            con.close();
            /////////////////////////////////////////         
        } catch (SQLException error3) {
            error3.printStackTrace();
        }
    }

}
