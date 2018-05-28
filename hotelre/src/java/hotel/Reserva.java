package hotel;

import java.util.Date;

public class Reserva {

    public int getNumN() {
        return numN;
    }

    
    public void setNumN(int numN) {
        this.numN = numN;
    }

    
    public String getHot() {
        return hot;
    }

    
    public void setHot(String hot) {
        this.hot = hot;
    }

   
    public String getTipH() {
        return tipH;
    }

    public void setTipH(String tipH) {
        this.tipH = tipH;
    }

    public String getFechl() {
        return fechl;
    }

    public int getNum() {
        return num;
    }

    
    public int getNumd() {
        return numd;
    }

    
    public int getNuma() {
        return numa;
    }

    clave cl = new clave();
    public String getLocalizador() {
        String claverandom = cl.getAlphaNumeric(5);
        localizador = claverandom;
        return localizador;
    }

    

    
    private int numN;
    private String hot;
    private String tipH;
    private String fechl;
    private int num;
    private int numd;
    private int numa;
    private String localizador;
    
    
    
    
    

    

}
