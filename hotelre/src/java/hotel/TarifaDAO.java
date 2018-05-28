
package hotel;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;


public interface TarifaDAO {
    
    
    public void insertarDatos(String query) throws SQLException,ParseException;
    
}
