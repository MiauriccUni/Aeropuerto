package valverde.ricardo.bl;

import java.util.Objects;

/**
 * @author Ricardo Valverde
 * @since 30/10/2022
 * @version 1.0
 */
public class LineasAereas {
    private String cedulaJuri;
   private String nombreAero;
   private String nombreDue;
   private Pais pais;

    /**
     * Constructor por defecto
     */

    public LineasAereas() {
    }


    /**
     * Constructor
     * @param nombreAero
     * @param cedulaJuri
     * @param nombreDue
     * @param pais
     */
    public LineasAereas(String cedulaJuri, String nombreAero, String nombreDue, Pais pais) {
        this.cedulaJuri = cedulaJuri;
        this.nombreAero = nombreAero;
        this.nombreDue = nombreDue;
        this.pais = pais;
    }

    public LineasAereas(String cedulaJuri, String nombreAero, String nombreDue) {
        this.cedulaJuri = cedulaJuri;
        this.nombreAero = nombreAero;
        this.nombreDue = nombreDue;
    }

    public String getCedulaJuri() {
        return cedulaJuri;
    }

    public void setCedulaJuri(String cedulaJuri) {
        this.cedulaJuri = cedulaJuri;
    }

    public String getNombreAero() {
        return nombreAero;
    }

    public void setNombreAero(String nombreAero) {
        this.nombreAero = nombreAero;
    }

    public String getNombreDue() {
        return nombreDue;
    }

    public void setNombreDue(String nombreDue) {
        this.nombreDue = nombreDue;
    }

    public Pais getPais() {
        return pais;
    }

    /**
     *Getter and Setter
     */


    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "LineasAereas{" +
                "cedulaJuri='" + cedulaJuri + '\'' +
                ", nombreAero='" + nombreAero + '\'' +
                ", nombreDue='" + nombreDue + '\'' +
                ", pais=" + pais +
                '}';
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineasAereas that = (LineasAereas) o;
        return Objects.equals(cedulaJuri, that.cedulaJuri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedulaJuri);
    }
}
