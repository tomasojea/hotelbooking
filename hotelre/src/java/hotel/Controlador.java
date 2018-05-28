package hotel;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
@WebFilter(urlPatterns = {"/*"})
public class Controlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String texto = request.getReader().readLine();
        
        //System.out.println(request.getRequestURL()); 
        //boolean requrl =request.getRequestURL();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uri = httpRequest.getRequestURI();
        boolean matches = uri.startsWith("/Controlador");
        if (!matches) {
//            response.setStatus(response.SC_MOVED_TEMPORARILY);
//            response.setHeader("Location", "index.html");
            out.print("Llenar el formulario");
        } else {
            System.out.println("No autorizado");

        }
        //response.setStatus(response.SC_MOVED_TEMPORARILY);
        //response.setHeader("Location", "registro.html");
//        TarifaDAOImp tarifa = new TarifaDAOImp(texto);
//        try {
//            tarifa.insertarDatos("INSERT INTO T_tarifa (precioNoche, fechaInicio, fechaFin, tarifa , codHotel, tipoHab) values ((SELECT precio  FROM T_tiphab  where codHotel= ? and tipo= ?), ? ,( ? + interval ? day), ?  * (select precio from T_tiphab where tipo= ? and codHotel= ?), ?, ?)");
//        } catch (SQLException | ParseException ex) {
//            System.out.println(ex);
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //String texto2 = request.getReader().readLine();
        //request.setAttribute("reserva", json);
        //System.out.println(texto2);
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Gson gson = new Gson();

            //response.sendRedirect("registro.html");
            //response.setStatus(response.SC_MOVED_TEMPORARILY);
            //response.setHeader("Location", "registro.html");
            PrintWriter out = response.getWriter();
            String texto = request.getReader().readLine();
            System.out.println(texto);

            ReservaDAOImp reserva = new ReservaDAOImp(texto);
            Reserva json = gson.fromJson(texto, Reserva.class);

            String disp = "select disponibilidad from T_tiphab where tipo=? and codHotel=?";
            String precio = "SELECT SUM( ?  * (select precio from T_tiphab where tipo= ? and codHotel= ?) ) AS total";
            if (reserva.disponibilidad(disp) >= 0) {
                out.print("$ " + reserva.disponibilidad(precio));

            } else {
                out.print("No hay disponibilidad");
            }
            //RequestDispatcher rd=request.getRequestDispatcher("/resgistro"); 

            //rd.forward(request, response);
            //reserva.reserva("insert into T_reserva (localizador,fechaLlegada,numNoches,numMenDos,numMenDosDoce,tipoHab,numAdultos,codHotel) values (?,?,?,?,?,?,?,?)", json);
            out.close();

            //out.print(reserva.disponibilidad("SELECT SUM( ?  * (select precio from T_tiphab where tipo= ? and codHotel= ?) ) AS total",rsv));
        } catch (SQLException ex) {
            System.out.println(ex);

        } catch (JsonSyntaxException gsone) {
            PrintWriter out = response.getWriter();
            out.print("Completa el puto formulario");
        }

    }

}
