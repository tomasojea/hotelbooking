package hotel;

import com.google.gson.Gson;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TarifaDAOImp implements TarifaDAO {

    Gson gson = new Gson();
    conexiontarifa con = new conexiontarifa();
    //Cliente cliente = null;
    Reserva reserva = null;

    public TarifaDAOImp(String texto) {

        reserva = gson.fromJson(texto, Reserva.class);
        
        
        //System.out.println(cliente.getProvincia());

    }

    @Override
    public void insertarDatos(String query) throws SQLException, ParseException {

        Date date;
        
        date = new SimpleDateFormat("yyyy-MM-dd").parse(reserva.getFechl());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        PreparedStatement busquedaStmt = null;
         
        con.consultas.add(query);
        //Iterator listIterator = con.consultas.listIterator();

        System.out.println("insertar datos (tarifa)");
        try {

            while (con.consultas.size() > 1) {

                String busquedaString1 = con.consultas.get(0);
                String busquedaString2 = con.consultas.get(1);
                String busquedaString3 = ("SET FOREIGN_KEY_CHECKS=0");
                System.out.println(con.consultas.get(0));
                System.out.println(con.consultas.get(1));

                con.getConexion().setAutoCommit(false);
                busquedaStmt = con.getConexion().prepareStatement(busquedaString3);
                busquedaStmt.execute();
                busquedaStmt = con.getConexion().prepareStatement(busquedaString1);
                busquedaStmt.setDate(1, sqlDate);
                busquedaStmt.setString(2, reserva.getLocalizador());
                busquedaStmt.execute();
                busquedaStmt = con.getConexion().prepareStatement(busquedaString2);
                busquedaStmt.setDate(1, sqlDate);
                busquedaStmt.setInt(2, reserva.getNumN());
                busquedaStmt.setDate(3, sqlDate);
                busquedaStmt.setString(4, reserva.getLocalizador());
                busquedaStmt.executeUpdate();
                con.getConexion().commit();
                con.closeConexion();
                System.out.println("funciona insertarDatos");
                System.out.println(reserva.getLocalizador());
                System.out.println("Tarifa: Metodo Insertar Datos");

                break;

            }

        } catch (SQLException ex) {

            System.out.println(ex);

        }

    }

}
