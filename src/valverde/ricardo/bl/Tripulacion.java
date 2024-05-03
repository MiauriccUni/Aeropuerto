package valverde.ricardo.bl;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Ricardo Valverde
 * @since 30/10/2022
 * @version 1.0
 */

public class Tripulacion {
    private String codigo;
    private String nombreClave;
    private String genero;
    private int añosExp;
    private LocalDate graduacion;
    private String licencia;
    private String puesto;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private String correo;
    private String telefono;
    private String Direccion;

    /**
     * Constructor por defecto
     */

    public Tripulacion() {
    }

    /**Constructor
     *
     * @param codigo
     * @param nombreClave
     * @param genero
     * @param añosExp
     * @param graduacion
     * @param licencia
     * @param puesto
     * @param nombre
     * @param apellidos
     * @param nacionalidad
     * @param correo
     * @param telefono
     * @param direccion
     */

    public Tripulacion(String codigo, String nombreClave, String genero, int añosExp, LocalDate graduacion, String licencia, String puesto, String nombre, String apellidos, String nacionalidad, String correo, String telefono, String direccion) {
        this.codigo = codigo;
        this.nombreClave = nombreClave;
        this.genero = genero;
        this.añosExp = añosExp;
        this.graduacion = graduacion;
        this.licencia = licencia;
        this.puesto = puesto;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.correo = correo;
        this.telefono = telefono;
        Direccion = direccion;
    }

    /**
     *Getter and Setter
     */

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreClave() {
        return nombreClave;
    }

    public void setNombreClave(String nombreClave) {
        this.nombreClave = nombreClave;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAñosExp() {
        return añosExp;
    }

    public void setAñosExp(int añosExp) {
        this.añosExp = añosExp;
    }

    public LocalDate getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(LocalDate graduacion) {
        this.graduacion = graduacion;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return
     */

    @Override
    public String toString() {
        return "Tripulacion{" +
                "codigo='" + codigo + '\'' +
                ", nombreClave='" + nombreClave + '\'' +
                ", genero='" + genero + '\'' +
                ", añosExp=" + añosExp +
                ", graduacion=" + graduacion +
                ", licencia='" + licencia + '\'' +
                ", puesto='" + puesto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", Direccion='" + Direccion + '\'' +
                '}';
    }
}
