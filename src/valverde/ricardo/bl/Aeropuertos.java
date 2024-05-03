package valverde.ricardo.bl;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Ricardo Valverde
 * @since 30/10/2022
 * @version 1.0
 */

public class Aeropuertos {
    private String codigo;
    private String nombreAero;
    private Pais pais;

    /**
     * Constructor por defecto
     */

    public Aeropuertos() {
    }

    /**
     * Constrctor, solamente para las variables nativas de la clase
     * @param codigo
     * @param nombreAero
     */
    public Aeropuertos(String codigo, String nombreAero) {
        this.codigo = codigo;
        this.nombreAero = nombreAero;
    }

    /**
     * Constructor, solamente para las variables de la clase @Pais
     * @param codigo
     * @param nombreAero
     * @param pais
     */
    public Aeropuertos(String codigo, String nombreAero, Pais pais) {
        this.codigo = codigo;
        this.nombreAero = nombreAero;
        this.pais = pais;
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

    public String getNombreAero() {
        return nombreAero;
    }

    public void setNombreAero(String nombreAero) {
        this.nombreAero = nombreAero;
    }



    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return
     */

    @Override
    public String toString() {
        return "Aeropuertos{" +
                "codigo='" + codigo + '\'' +
                ", nombreAero='" + nombreAero + '\'' +
                ", pais=" + pais +
                '}';
    }

    /**
     * Creacion del equals to para las busquedas
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeropuertos that = (Aeropuertos) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
