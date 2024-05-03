package valverde.ricardo.bl;
/**
 * @author Ricardo Valverde
 * @since 30/10/2022
 * @version 1.0
 */
public class Aeronaves {
    private String placa;
    private String marcaFabrican;
    private String modelo;
    private int capacidad;


    /**
     * Constructor por defecto
     */
    public Aeronaves() {
    }

    /**
     * Constructor
     * @param placa
     * @param marcaFabrican
     * @param modelo
     * @param capacidad
     */

    public Aeronaves(String placa, String marcaFabrican, String modelo, int capacidad) {
        this.placa = placa;
        this.marcaFabrican = marcaFabrican;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    /**
     *Getter and Setter
     */

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarcaFabrican() {
        return marcaFabrican;
    }

    public void setMarcaFabrican(String marcaFabrican) {
        this.marcaFabrican = marcaFabrican;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Metodo que devuelve los atributos en formato String
     * @return
     */

    @Override
    public String toString() {
        return "Aeronaves{" +
                "placa='" + placa + '\'' +
                ", marcaFabrican='" + marcaFabrican + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidad='" + capacidad + '\'' +
                '}';
    }
}
