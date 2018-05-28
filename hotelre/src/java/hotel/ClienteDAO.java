package hotel;

import java.util.ArrayList;
import java.util.List;

public interface ClienteDAO {

    public ArrayList disponibilidad(String query);

    
    public void reserva(String query);

}
