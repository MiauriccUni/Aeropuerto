package valverde.ricardo.bl;

import java.util.ArrayList;
import java.util.Date;
/**
 * @author Ricardo Valverde
 * @since 30/10/2022
 * @version 1.0
 */

public class VuelosProgramados {

    private String codigo;
    private Date horaLlegada;
    private Date horaSalida;
    private String estado;
    private String paisOrig;
    private String paisDest;
    private String tipoSOE;
    private int asientos;
    private ArrayList<Pais> pais;
    private ArrayList<Aeronaves> aeronave;
    private ArrayList<LineasAereas>lineaaerea;
    private ArrayList<Tripulacion>tripulacion;
    private ArrayList<Salas>sala;
    private ArrayList<Aeropuertos>aeropuerto;

    public VuelosProgramados() {
    }

    public VuelosProgramados(String codigo, Date horaLlegada, Date horaSalida, String estado, String paisOrig, String paisDest, String tipoSOE, int asientos, ArrayList<Pais> pais, ArrayList<Aeronaves> aeronave, ArrayList<LineasAereas> lineaaerea, ArrayList<Tripulacion> tripulacion, ArrayList<Salas> sala, ArrayList<Aeropuertos> aeropuerto) {
        this.codigo = codigo;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.estado = estado;
        this.paisOrig = paisOrig;
        this.paisDest = paisDest;
        this.tipoSOE = tipoSOE;
        this.asientos = asientos;
        this.pais = pais;
        this.aeronave = aeronave;
        this.lineaaerea = lineaaerea;
        this.tripulacion = tripulacion;
        this.sala = sala;
        this.aeropuerto = aeropuerto;
    }

    public VuelosProgramados(String codigo, Date horaLlegada, Date horaSalida, String estado, String paisDest, String paisOrig, String tipoSOE, int asientos) {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPaisOrig() {
        return paisOrig;
    }

    public void setPaisOrig(String paisOrig) {
        this.paisOrig = paisOrig;
    }

    public String getPaisDest() {
        return paisDest;
    }

    public void setPaisDest(String paisDest) {
        this.paisDest = paisDest;
    }

    public String getTipoSOE() {
        return tipoSOE;
    }

    public void setTipoSOE(String tipoSOE) {
        this.tipoSOE = tipoSOE;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public ArrayList<Pais> getPais() {
        return pais;
    }

    public void setPais(ArrayList<Pais> pais) {
        this.pais = pais;
    }

    public ArrayList<Aeronaves> getAeronave() {
        return aeronave;
    }

    public void setAeronave(ArrayList<Aeronaves> aeronave) {
        this.aeronave = aeronave;
    }

    public ArrayList<LineasAereas> getLineaaerea() {
        return lineaaerea;
    }

    public void setLineaaerea(ArrayList<LineasAereas> lineaaerea) {
        this.lineaaerea = lineaaerea;
    }

    public ArrayList<Tripulacion> getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(ArrayList<Tripulacion> tripulacion) {
        this.tripulacion = tripulacion;
    }

    public ArrayList<Salas> getSala() {
        return sala;
    }

    public void setSala(ArrayList<Salas> sala) {
        this.sala = sala;
    }

    public ArrayList<Aeropuertos> getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(ArrayList<Aeropuertos> aeropuerto) {
        this.aeropuerto = aeropuerto;
    }



    @Override
    public String toString() {
        return "VuelosProgramados{" +
                "Codigo=" + codigo +
                "horaLlegada=" + horaLlegada +
                ", horaSalida=" + horaSalida +
                ", estado='" + estado + '\'' +
                ", paisOrig='" + paisOrig + '\'' +
                ", paisDest='" + paisDest + '\'' +
                ", tipoSOE='" + tipoSOE + '\'' +
                ", asientos=" + asientos +
                ", pais=" + pais +
                ", aeronave=" + aeronave +
                ", lineaaerea=" + lineaaerea +
                ", tripulacion=" + tripulacion +
                ", sala=" + sala +
                ", aeropuerto=" + aeropuerto +
                '}';
    }

    public void remove(ArrayList<VuelosProgramados> vuelo) {
    }
}
