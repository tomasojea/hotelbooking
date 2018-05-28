package hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAOImp implements ClienteDAO {

    @Override
    public ArrayList disponibilidad(String query) {
        
        ArrayList listacliente = new ArrayList();
        hotercon con = new hotercon();

        PreparedStatement busquedaStmt = null;
        String busquedaString = query;
        
        try {

            busquedaStmt = con.getConexion().prepareStatement(busquedaString);
            busquedaStmt.setInt(1, 1);
            busquedaStmt.setString(2, "df");
            ResultSet rs = busquedaStmt.executeQuery();

            while (rs.next()) {
                
                System.out.println(listacliente.add(rs.getInt("libre")));

            }
        } catch (SQLException ex) {
            
            Logger.getLogger(ClienteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        con.closeConexion();
        return listacliente;

    }

    @Override
    public void reserva(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
