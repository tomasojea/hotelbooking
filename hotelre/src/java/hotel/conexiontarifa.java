
package hotel;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class conexiontarifa {
 Connection con = null;

    public  ArrayList<String> consultas = new ArrayList<>();
    public conexiontarifa() {
        System.out.println("ejecutate conexion tarifa");
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
