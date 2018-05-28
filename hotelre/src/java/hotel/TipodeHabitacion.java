
package hotel;


public class TipodeHabitacion {
    
    private String tipo;
    private int NumMaxPersonas;
    private String Disponibilidad;

   
    public String getTipo() {
        return tipo;
    }

    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public int getNumMaxPersonas() {
        return NumMaxPersonas;
    }

    
    public void setNumMaxPersonas(int NumMaxPersonas) {
        this.NumMaxPersonas = NumMaxPersonas;
    }

   
    public String getDisponibilidad() {
        return Disponibilidad;
    }

   
    public void setDisponibilidad(String Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }
    
}
