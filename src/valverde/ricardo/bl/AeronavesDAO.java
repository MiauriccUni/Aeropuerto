package valverde.ricardo.bl;

import java.sql.*;
import java.util.ArrayList;

public class AeronavesDAO {

    public void insertarAeronaves(Aeronaves aeronaves){
        try {
            //creo una nueva instancia del archivo de configuracion
            Configuracion configuracion = new Configuracion();
            //lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConextion = configuracion.getStringConexion();
            String query = "INSERT INTO AERONAVES (PLACA,MarcaFabrican,modelo,capacidad) VALUES(?,?,?,?)";
            conn = DriverManager.getConnection(strConextion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,aeronaves.getPlaca());
            stmt.setString(2,aeronaves.getMarcaFabrican());
            stmt.setString(3,aeronaves.getModelo());
            stmt.setInt(4,aeronaves.getCapacidad());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Aeronaves> listarAeronave(){

        ArrayList<Aeronaves> aeronaves = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM AERONAVES";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);//el rs almacena la informacion de la base de datos

            while (rs.next()){//rs.next() devuelve true si hay mas lineas en el result set por defecto al iniciar el rs esta en 0
                Aeronaves aeronaves1 = new Aeronaves();
                aeronaves1.setPlaca(rs.getString("PLACA"));
                aeronaves1.setMarcaFabrican(rs.getString("MarcaFabrican"));
                aeronaves1.setModelo(rs.getString("modelo"));
                aeronaves1.setCapacidad(rs.getInt("capacidad"));
                aeronaves.add(aeronaves1);
            }
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aeronaves;
    }


    public void actualizarAeronave(Aeronaves aeronaves){
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE AERONAVES SET PLACA=?, MARCAFABRICAN=?,MODELO=?,CAPACIDAD=?"+"where PLACA= ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,aeronaves.getPlaca());
            stmt.setString(2,aeronaves.getMarcaFabrican());
            stmt.setString(3,aeronaves.getModelo());
            stmt.setInt(4,aeronaves.getCapacidad());
            stmt.setString(5,aeronaves.getPlaca());
            stmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarAeronave(Aeronaves aeronaves){
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "DELETE FROM Aeronaves WHERE PLACA = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,aeronaves.getPlaca());
            stmt.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
