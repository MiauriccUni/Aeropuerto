package valverde.ricardo.bl;
/**
 * @author Ricardo Valverde
 * @since 30/10/2022
 * @version 1.0
 */

public class Tiquetes {
    private String codigoPais;
    private int numeroAsiento;
    private double precio;
    private String tipoAsiento;
    private int numeroVuelo;


    private Pais paisOrig;
    private Pais paisDest;
    private Aeropuertos aeroOrigen;
    private Aeropuertos aeroDestino;

    public Tiquetes() {
    }

    public Tiquetes(String codigoPais, int numeroAsiento, double precio, String tipoAsiento, int numeroVuelo, Pais paisOrig, Pais paisDest, Aeropuertos aeroOrigen, Aeropuertos aeroDestino) {
        this.codigoPais = codigoPais;
        this.numeroAsiento = numeroAsiento;
        this.precio = precio;
        this.tipoAsiento = tipoAsiento;
        this.numeroVuelo = numeroVuelo;
        this.paisOrig = paisOrig;
        this.paisDest = paisDest;
        this.aeroOrigen = aeroOrigen;
        this.aeroDestino = aeroDestino;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public int getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(int numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public Pais getPaisOrig() {
        return paisOrig;
    }

    public void setPaisOrig(Pais paisOrig) {
        this.paisOrig = paisOrig;
    }

    public Pais getPaisDest() {
        return paisDest;
    }

    public void setPaisDest(Pais paisDest) {
        this.paisDest = paisDest;
    }

    public Aeropuertos getAeroOrigen() {
        return aeroOrigen;
    }

    public void setAeroOrigen(Aeropuertos aeroOrigen) {
        this.aeroOrigen = aeroOrigen;
    }

    public Aeropuertos getAeroDestino() {
        return aeroDestino;
    }

    public void setAeroDestino(Aeropuertos aeroDestino) {
        this.aeroDestino = aeroDestino;
    }

    @Override
    public String toString() {
        return "Tiquetes{" +
                "codigoPais='" + codigoPais + '\'' +
                ", numeroAsiento=" + numeroAsiento +
                ", precio=" + precio +
                ", tipoAsiento='" + tipoAsiento + '\'' +
                ", numeroVuelo=" + numeroVuelo +
                ", paisOrig=" + paisOrig +
                ", paisDest=" + paisDest +
                ", aeroOrigen=" + aeroOrigen +
                ", aeroDestino=" + aeroDestino +
                '}';
    }
}
