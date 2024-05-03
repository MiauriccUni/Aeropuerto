package valverde.ricardo.bl;

/**
 * @author Ricardo Valverde
 * @since 30/10/2022
 * @version 1.0
 */
public class Pais {
    private String ide;
    private String pais;
    private String abreviatura;


    /**
     * Constructor por defecto
     */
    public Pais() {
    }

    /**
     * Contructor
     * @param ide
     * @param pais
     * @param abreviatura
     */
    public Pais(String ide, String pais, String abreviatura) {
        this.ide = ide;
        this.pais = pais;
        this.abreviatura = abreviatura;
    }
/**
     *Getter and Setter
     */
    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

/**
     * Metodo que devuelve los atributos en formato String
     * @return
     */

    @Override
    public String toString() {
        return "Pais{" +
                "ide='" + ide + '\'' +
                ", pais='" + pais + '\'' +
                ", abreviatura='" + abreviatura + '\'' +
                '}';
    }
}
