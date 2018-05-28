
package hotel;


public class Tarifa {
    
    private int PrecioPorNoche;
    private int FechaInicio;
    private int FechaFin;
    private String tipoHab;

    
    public int getPrecioPorNoche() {
        return PrecioPorNoche;
    }

    
    public void setPrecioPorNoche(int PrecioPorNoche) {
        this.PrecioPorNoche = PrecioPorNoche;
    }

    public int getFechaInicio() {
        return FechaInicio;
    }

    
    public void setFechaInicio(int FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    
    public int getFechaFin() {
        return FechaFin;
    }

    
    public void setFechaFin(int FechaFin) {
        this.FechaFin = FechaFin;
    }

   
    public String getTipoHab() {
        return tipoHab;
    }

   
    public void setTipoHab(String tipoHab) {
        this.tipoHab = tipoHab;
    }
    
}
