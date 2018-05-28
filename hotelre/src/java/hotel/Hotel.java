
package hotel;


public class Hotel {
    
    private String Nombre;
    private int FechaMax;
    private int NumMaxNoches;

   
    public String getNombre() {
        return Nombre;
    }

   
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getFechaMax() {
        return FechaMax;
    }

    
    public void setFechaMax(int FechaMax) {
        this.FechaMax = FechaMax;
    }

    public int getNumMaxNoches() {
        return NumMaxNoches;
    }

    
    public void setNumMaxNoches(int NumMaxNoches) {
        this.NumMaxNoches = NumMaxNoches;
    }
    
    
}
