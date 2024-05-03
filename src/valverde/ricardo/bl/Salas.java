package valverde.ricardo.bl;

import java.util.ArrayList;

/**
 * @author Ricardo Valverde
 * @since 30/10/2022
 * @version 1.0
 */
public class Salas {
    private String codigo;
    private String nombre;
    private String ubicacion;
    private String piso;

    /**
     * Constructor por defecto
     */

    public Salas() {
    }

    /**
     * Constructor
     * @param nombre
     * @param codigo
     * @param ubicacion
     * @param piso
     */

    public Salas(String codigo, String nombre, String ubicacion, String piso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.piso = piso;
    }

    /**
     *Getter and Setter
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return
     */

    @Override
    public String toString() {
        return "Salas{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", piso='" + piso + '\'' +
                '}';
    }

    public void remove(ArrayList<Salas> sala) {
    }
}
