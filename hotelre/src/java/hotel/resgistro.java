package hotel;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "resgistro", urlPatterns = {"/resgistro"})
public class resgistro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();

        //Convierte el objecto del .getAttribute("reserva") a objecto "Reserva".
        Reserva reservajson = (Reserva) request.getAttribute("reserva");
        System.out.println(reservajson + "servlet Registro");
        System.out.println(reservajson.getFechl());
        //Transforma los datos(json) enviados por el cliente atraves de AJAX en objeto "Cliente".

        //Instancia el objeto "clienteconexion" el cual tiene los metodos para conexion a la base de datos.
        String respjson = request.getReader().readLine();
        Cliente clientejson = gson.fromJson(respjson, Cliente.class);
        clienteconexion conect = new clienteconexion();
        //Obtiene la conexion con la BBDD.
        conect.getConexion();
        PreparedStatement busquedaStmt = null;

        try {
            busquedaStmt = conect.getConexion().prepareStatement("insert into T_cliente (codCliente,nombre,apellido,direccion,provincia,pais,codigo_postal,telefono,movil,email) values (?,?,?,?,?,?,?,?,?,?)");
            busquedaStmt.setString(1, clientejson.getCodCliente());
            busquedaStmt.setString(2, clientejson.getNombre());
            busquedaStmt.setString(3, clientejson.getApellido());
            busquedaStmt.setString(4, clientejson.getDireccion());
            busquedaStmt.setString(5, clientejson.getProvincia());
            busquedaStmt.setString(6, clientejson.getPais());
            busquedaStmt.setString(7, clientejson.getCodigoPostal());
            busquedaStmt.setString(8, clientejson.getTelefono());
            busquedaStmt.setString(9, clientejson.getMovil());
            busquedaStmt.setString(10, clientejson.getEmail());
            busquedaStmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

}
