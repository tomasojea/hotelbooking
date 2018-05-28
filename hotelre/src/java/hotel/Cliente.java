package hotel;

public class Cliente {

  
   

    //private String CodCliente;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private String Provincia;
    private String Pais;
    private String CodigoPostal;
    private String Telefono;
    private String Movil;
    private String Mail;
    private String CodCliente;
    private String NumTarjeta;
    private String CadTarjeta;
    private String TipoTarjeta;

   
   
    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

   
    public String getDireccion() {
        return Direccion;
    }

    public String getProvincia() {
        return Provincia;
    }

    
    public String getPais() {
        return Pais;
    }

    public String getCodigoPostal() {
        return CodigoPostal;
    }

    
    public String getTelefono() {
        return Telefono;
    }

    
    public String getMovil() {
        return Movil;
    }

    
    public String getEmail() {
        return Mail;
    }

    
   clave cl = new clave();
    public String getCodCliente() {
        String claverandom = cl.getAlphaNumeric(5);
        CodCliente = claverandom;
        System.out.println(CodCliente);
        return CodCliente;
    }
    
    
     public String getNumTarjeta() {
        return NumTarjeta;
    }

    
   
    public String getCadTarjeta() {
        return CadTarjeta;
    }

    

   
    public String getTipoTarjeta() {
        return TipoTarjeta;
    }


    

}
