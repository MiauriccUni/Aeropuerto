package valverde.ricardo.bl;

import java.sql.*;
import java.util.ArrayList;

public class AeropuertosDAO {

    public void insertarAeropuerto(Aeropuertos aeropuertos){
        try {
            //creo una nueva instancia del archivo de configuracion
            Configuracion configuracion = new Configuracion();
            //lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConextion = configuracion.getStringConexion();
            String query = "INSERT INTO AEROPUERTOS (CODIGO,NOMBREAERO,PAIS) VALUES(?,?,?)";
            conn = DriverManager.getConnection(strConextion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,aeropuertos.getCodigo());
            stmt.setString(2,aeropuertos.getNombreAero());
            stmt.setString(3,aeropuertos.getPais().getIde());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Aeropuertos> listaraeropuerto(){
        ArrayList<Aeropuertos> aeropuertos = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM AEROPUERTOS";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);//el rs almacena la informacion de la base de datos

            while (rs.next()){//rs.next() devuelve true si hay mas lineas en el result set por defecto al iniciar el rs esta en 0
                Aeropuertos aeropuertos1 = new Aeropuertos();
                aeropuertos1.setCodigo(rs.getString("CODIGO"));
                aeropuertos1.setNombreAero(rs.getString("NOMBREAERO"));
                PaisDAO paisDAO = new PaisDAO();
                aeropuertos1.setPais(paisDAO.obtenerPais(rs.getNString("PAIS")));
            aeropuertos.add(aeropuertos1);
            }
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aeropuertos;
    }
    public void actualizarAeropuerto(Aeropuertos aeropuertos){
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE AEROPUERTOS SET CODIGO=?,NOMBREAERO=?"+"where CODIGO = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,aeropuertos.getCodigo());
            stmt.setString(2,aeropuertos.getNombreAero());
            stmt.setString(3,aeropuertos.getCodigo());
            stmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarAeropuerto(Aeropuertos aeropuertos){
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "DELETE FROM AEROPUERTOS WHERE CODIGO = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,aeropuertos.getCodigo());
            stmt.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
