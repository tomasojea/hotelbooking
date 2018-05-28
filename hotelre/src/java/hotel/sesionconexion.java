
package hotel;

import static hotel.hotercon.con;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class sesionconexion {

    public sesionconexion() {
        System.out.println("ejecutate");
        try {
            //////////////////////////////////////////////////////////////////////////////////////////////      
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/usuario", "root", "root");
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

    public static String toSHA1(String convertme) {
        MessageDigest md = null;
        byte[] bytes = convertme.getBytes();
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return byteArrayToHexString(md.digest(bytes));
    }

    public static String byteArrayToHexString(byte[] b) {
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result;
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
