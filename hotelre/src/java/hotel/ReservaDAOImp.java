package hotel;

import com.google.gson.Gson;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservaDAOImp implements ReservaDAO {
    Gson gson = new Gson();
    hotercon con = new hotercon();
    int disp = 0;
    int precio = 0;
    Reserva json =null;
    
    

    public ReservaDAOImp(String texto) {
        
       json = gson.fromJson(texto, Reserva.class); 
       
       
       
       
    }
    
   
    @Override
    public int disponibilidad(String query) throws SQLException {
       
        System.out.println("metodo disponibilidad");
        con.consultas.add(query);
        PreparedStatement busquedaStmt = null;
        //String busquedaString = query;
        System.out.println(con.consultas.get(0));

        //String busquedaString1 = con.consultas.get(0);
        if (con.consultas.size() >= 2) {
            System.out.println(con.consultas.get(1));
            con.getConexion().setAutoCommit(false);
            busquedaStmt = con.getConexion().prepareStatement(con.consultas.get(0));
            busquedaStmt.setString(1, json.getTipH());
            busquedaStmt.setString(2, json.getHot());
            ResultSet rs = busquedaStmt.executeQuery();

            while (rs.next()) {
                disp = rs.getInt("disponibilidad");
                disp = disp - 1;

                System.out.println(rs.getString("disponibilidad"));

            }

            busquedaStmt = con.getConexion().prepareStatement(con.consultas.get(1));
            busquedaStmt.setInt(1, json.getNumN());
            busquedaStmt.setString(2, json.getTipH());
            busquedaStmt.setString(3, json.getHot());
            ResultSet rs1 = busquedaStmt.executeQuery();

            while (rs1.next()) {
                precio = rs1.getInt("total");

                System.out.println(precio);

            }

            con.getConexion().commit();

        } else {
            System.out.println("Siguiente consulta");
        }

        return precio;

    }

    @Override
    public void reserva(String query) throws ParseException, SQLException {

        PreparedStatement busquedaStmt = null;

        String busquedaString = query;
        String busquedaString3 = ("SET FOREIGN_KEY_CHECKS=0");
        Date date;

        date = new SimpleDateFormat("yyyy-MM-dd").parse(json.getFechl());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        con.getConexion().setAutoCommit(false);
        
        busquedaStmt = con.getConexion().prepareStatement(busquedaString3);
        busquedaStmt.execute();
        busquedaStmt = con.getConexion().prepareStatement(busquedaString);
        busquedaStmt.setString(1, json.getLocalizador());
        busquedaStmt.setDate(2, sqlDate);
        busquedaStmt.setInt(3, json.getNumN());
        busquedaStmt.setInt(4, json.getNum());
        busquedaStmt.setInt(5, json.getNumd());
        busquedaStmt.setString(6, json.getTipH());
        busquedaStmt.setInt(7, json.getNuma());
        busquedaStmt.setString(8, json.getHot());
        busquedaStmt.executeUpdate();
        busquedaString = "update  T_tiphab set disponibilidad = ?  where tipo=? and codHotel=?";
        busquedaStmt = con.getConexion().prepareStatement(busquedaString);
        busquedaStmt.setInt(1, disp);
        busquedaStmt.setString(2, json.getTipH());
        busquedaStmt.setString(3, json.getHot());
        busquedaStmt.executeUpdate();
        con.getConexion().commit();

        con.closeConexion();

    }

}
