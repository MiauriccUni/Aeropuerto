package valverde.ricardo.bl;
/**
 * @author Ricardo Valverde
 * @since 30/10/2022
 * @version 1.0
 */

import java.util.Date;
import java.util.Objects;

public class Usuarios {
    private String cedula;
    private String nombre;
    private String correo;
    private String contraseña;

    /**
     * Constructor por defecto
     */

    public Usuarios() {
    }

    public Usuarios(String cedula, String nombre, String correo, String contraseña) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return
     */

    @Override
    public String toString() {
        return "Administrador{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correo='" + correo + '\'' +
                ", contraseña=" + contraseña +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios that = (Usuarios) o;
        return Objects.equals(cedula, that.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
}
