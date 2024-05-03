package valverde.ricardo.Gestor;

import valverde.ricardo.bl.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Gestor {
    private PaisDAO paisDAO;
    private AeropuertosDAO aeropuertosDAO;
    private LineasAereasDAO lineasAereasDAO;
    private AeronavesDAO aeronavesDAO;
    private SalasDAO salasDAO;
    private TripulacionDAO tripulacionDAO;
    private UsuariosDAO usuariosDAO;

    public Gestor() {
        //inicializar las variables para ejecutar los dao
        paisDAO = new PaisDAO();
        aeropuertosDAO = new AeropuertosDAO();
        lineasAereasDAO = new LineasAereasDAO();
        aeronavesDAO = new AeronavesDAO();
        salasDAO = new SalasDAO();
        tripulacionDAO = new TripulacionDAO();
        usuariosDAO = new UsuariosDAO();
    }

    public boolean insertarPais(Pais tmpPais){
        boolean duplicado = false;
        for(Pais pais : paisDAO.listarPais()){
            if(pais.equals((tmpPais)))
                duplicado = true;
        }
        if(!duplicado)
            paisDAO.insertarPais(tmpPais);
        return duplicado;
    }

    public ArrayList<Pais> listarPais() {
        return paisDAO.listarPais();
    }

    public boolean eliminarPais(Pais tmpPais)throws SQLException, ClassNotFoundException{
        boolean existe = false;
        for(Pais curso:paisDAO.listarPais()) {
            if (curso.getPais().equals(tmpPais))
                existe = true;
        }
        if(!existe)
            paisDAO.eliminarPais(tmpPais);
        return existe;
    }

    public void actualizarPais(Pais tmpPais) throws SQLException, ClassNotFoundException{
        paisDAO.actualizarPais(tmpPais);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////


    public boolean insertarAeropuerto(Aeropuertos tmpAeropuerto){
        boolean duplicado = false;
        for(Aeropuertos aeropuertos : aeropuertosDAO.listaraeropuerto()){
            if(aeropuertos.equals((tmpAeropuerto)))
                duplicado = true;
        }
        if(!duplicado)
            aeropuertosDAO.insertarAeropuerto(tmpAeropuerto);
        return duplicado;
    }

    public ArrayList<Aeropuertos> listarAeropuerto() throws SQLException, ClassNotFoundException{
        return aeropuertosDAO.listaraeropuerto();
    }

    public boolean eliminarAeropuerto(Aeropuertos tmpAeropuerto)throws SQLException, ClassNotFoundException{
        boolean existe = false;
        for(Aeropuertos aeropuertos:aeropuertosDAO.listaraeropuerto()) {
            if (aeropuertos.getCodigo().equals(tmpAeropuerto))
                existe = true;
        }
        if(!existe)
            aeropuertosDAO.eliminarAeropuerto(tmpAeropuerto);
        return existe;
    }

    public void actualizarAeropuerto(Aeropuertos tmpAeropuerto) throws SQLException, ClassNotFoundException{
        aeropuertosDAO.actualizarAeropuerto(tmpAeropuerto);
    }

    ////////////////////////////////////////////////////////////////////////////
    public boolean insertarAerolinea(LineasAereas tmpLineasAereas){
        boolean duplicado = false;
        for(LineasAereas lineasAereas : lineasAereasDAO.listarLineasAereas()){
            if(lineasAereasDAO.equals((tmpLineasAereas)))
                duplicado = true;
        }
        if(!duplicado)
            lineasAereasDAO.insertarLineaAerea(tmpLineasAereas);
        return duplicado;
    }

    public ArrayList<LineasAereas> listarLineasaereas() throws SQLException, ClassNotFoundException{
        return lineasAereasDAO.listarLineasAereas();
    }

    public boolean eliminarLineaAerea(LineasAereas tmpLineasAereas)throws SQLException, ClassNotFoundException{
        boolean existe = false;
        for(LineasAereas lineasAereas:lineasAereasDAO.listarLineasAereas()) {
            if (lineasAereas.getCedulaJuri().equals(tmpLineasAereas))
                existe = true;
        }
        if(!existe)
            lineasAereasDAO.eliminarLienasAereas(tmpLineasAereas);
        return existe;
    }

    public void actualizarLineasAereas(LineasAereas tmpLineasAereas) throws SQLException, ClassNotFoundException{
        lineasAereasDAO.actualizarLineasAereas(tmpLineasAereas);
    }
//////////////////////////////////////////////////////////////////////////////////////////

    public boolean insertarAeronave(Aeronaves tmpAeronaves){
        boolean duplicado = false;
        for(Aeronaves aeronaves : aeronavesDAO.listarAeronave()){
            if(aeronavesDAO.equals((tmpAeronaves)))
                duplicado = true;
        }
        if(!duplicado)
            aeronavesDAO.insertarAeronaves(tmpAeronaves);
        return duplicado;
    }

    public ArrayList<Aeronaves> listarAeronaves() throws SQLException, ClassNotFoundException{
        return aeronavesDAO.listarAeronave();
    }

    public boolean eliminarAeronave(Aeronaves tmpAeronaves)throws SQLException, ClassNotFoundException{
        boolean existe = false;
        for(Aeronaves aeronaves:aeronavesDAO.listarAeronave()) {
            if (aeronaves.getPlaca().equals(tmpAeronaves))
                existe = true;
        }
        if(!existe)
            aeronavesDAO.eliminarAeronave(tmpAeronaves);
        return existe;
    }

    public void actualizarAeronave(Aeronaves tmpAeronaves) throws SQLException, ClassNotFoundException{
        aeronavesDAO.actualizarAeronave(tmpAeronaves);
    }

////////////////////////////////////////////////////////////////////////////

    public boolean insertarSala(Salas tmpSala){
        boolean duplicado = false;
        for(Salas salas : salasDAO.listarSala()){
            if(salas.equals((tmpSala)))
                duplicado = true;
        }
        if(!duplicado)
            salasDAO.insertarSala(tmpSala);
        return duplicado;
    }

    public ArrayList<Salas> listarSala() {
        return salasDAO.listarSala();
    }

    public boolean eliminarSala(Salas tmpSala)throws SQLException, ClassNotFoundException{
        boolean existe = false;
        for(Salas salas:salasDAO.listarSala()) {
            if (salas.getCodigo().equals(tmpSala))
                existe = true;
        }
        if(!existe)
            salasDAO.eliminarSala(tmpSala);
        return existe;
    }

    public void actualizarSala(Salas tmpSala) throws SQLException, ClassNotFoundException{
        salasDAO.actualizarSala(tmpSala);
    }
    ////////////////////////////////////////////////////////////////////////////////

    public boolean insertarTripulante(Tripulacion tripulacion){
        boolean duplicado = false;
        for(Tripulacion tripulacion1 : tripulacionDAO.listarTripulacion()){
            if(tripulacion1.equals((tripulacion)))
                duplicado = true;
        }
        if(!duplicado)
            tripulacionDAO.insertarPais(tripulacion);
        return duplicado;
    }

    public ArrayList<Tripulacion> listarTripulacion() {
        return tripulacionDAO.listarTripulacion();
    }

    public boolean eliminarTripulacion(Tripulacion tripulacion)throws SQLException, ClassNotFoundException{
        boolean existe = false;
        for(Tripulacion tripulacion1:tripulacionDAO.listarTripulacion()) {
            if (tripulacion1.getCodigo().equals(tripulacion))
                existe = true;
        }
        if(!existe)
            tripulacionDAO.eliminarTripulacion(tripulacion);
        return existe;
    }

    public void actualizarTripulacion(Tripulacion tripulacion) throws SQLException, ClassNotFoundException{
        tripulacionDAO.actualizarTripulacion(tripulacion);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////
public boolean insertarUsuario(Usuarios usuarios){
    boolean duplicado = false;
    for(Usuarios usuarios1 : usuariosDAO.listarUsuarios()){
        if(usuarios1.equals((usuarios)))
            duplicado = true;
    }
    if(!duplicado)
        usuariosDAO.insertarUsuario(usuarios);
    return duplicado;
}

    public ArrayList<Usuarios> listarUsuarios() {
        return usuariosDAO.listarUsuarios();
    }

    public boolean eliminarUsuario(Usuarios usuarios)throws SQLException, ClassNotFoundException{
        boolean existe = false;
        for(Usuarios usuarios1:usuariosDAO.listarUsuarios()) {
            if (usuarios1.getCedula().equals(usuarios))
                existe = true;
        }
        if(!existe)
            usuariosDAO.eliminarUsuario(usuarios);
        return existe;
    }

    public void actualizarUsuarios(Usuarios usuarios) throws SQLException, ClassNotFoundException{
        usuariosDAO.actualizarUsuarios(usuarios);
    }
}
