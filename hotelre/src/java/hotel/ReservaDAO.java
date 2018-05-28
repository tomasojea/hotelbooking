
package hotel;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;


public interface ReservaDAO {
    
    public int disponibilidad(String query) throws SQLException;

    
    public void reserva(String query) throws ParseException,SQLException;
    
    
}
