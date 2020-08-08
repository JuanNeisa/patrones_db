package clases;

/**
 * @author patrones
 */
public class Persona {
    //Identifica la CC de la persona
    private int idPersona;
    //Representa la contraseña de usuario de la persona
    private String p_contra;
    //Identifica la llave del cargo al cual esta relacionado actualmente
    private int idCargo;
    //Describe el nombre de la persona
    private String p_nombre;
    //Describe el celular de contacto de la persona
    private int p_celular;
    //Identifica la CC del Jefe al cual esta bajo cargo. Si es jefe el espacio queda 'null'
    private int idJefe;
    //Identifica la bodega que se encuentra actualmente trabajando.
    private int idBodega;

    public Persona() {
    }

    /**
     * Esta clase describe los datos de una persona o trbajador que se encontrara asociado a la empresa, utilizando los parametros descritos en la base de datos
     * @param idPersona Identifica la CC de la persona
     * @param p_contra Identifica la contraseña de usuario del trabajador o persona
     * @param idCargo Identifica la llave del cargo al cual esta relacionado actualmente
     * @param p_nombre Describe el nombre de la persona
     * @param p_celular Describe el celular de contacto de la persona
     * @param idJefe Identifica la CC del Jefe al cual esta bajo cargo. Si es jefe el espacio queda 'null'
     * @param idBodega Identifica la bodega que se encuentra actualmente trabajando.
     */
    public Persona(int idPersona,String p_contra, int idCargo, String p_nombre, int p_celular, int idJefe, int idBodega) {
        this.idPersona = idPersona;
        this.idCargo = idCargo;
        this.p_nombre = p_nombre;
        this.p_celular = p_celular;
        this.idJefe = idJefe;
        this.idBodega = idBodega;
    }

    public String getP_contra() {
        return p_contra;
    }

    public void setP_contra(String p_contra) {
        this.p_contra = p_contra;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getP_nombre() {
        return p_nombre;
    }

    public void setP_nombre(String p_nombre) {
        this.p_nombre = p_nombre;
    }

    public int getP_celular() {
        return p_celular;
    }

    public void setP_celular(int p_celular) {
        this.p_celular = p_celular;
    }

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", idCargo=" + idCargo + ", p_nombre=" + p_nombre + ", p_celular=" + p_celular + ", idJefe=" + idJefe + ", idBodega=" + idBodega + '}';
    }
    
}
