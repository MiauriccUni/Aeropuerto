package valverde.ricardo.bl;

import java.sql.*;
import java.util.ArrayList;

public class SalasDAO {
    public void insertarSala(Salas salas){
        try {
            //creo una nueva instancia del archivo de configuracion
            Configuracion configuracion = new Configuracion();
            //lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConextion = configuracion.getStringConexion();
            String query = "INSERT INTO SALAS (CODIGO,NOMBRE,UBICACION,PISO) VALUES(?,?,?,?)";
            conn = DriverManager.getConnection(strConextion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,salas.getCodigo());
            stmt.setString(2,salas.getNombre());
            stmt.setString(3,salas.getUbicacion());
            stmt.setString(4,salas.getPiso());
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Salas> listarSala(){
        ArrayList<Salas> salas = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM SALAS";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);//el rs almacena la informacion de la base de datos

            while (rs.next()){//rs.next() devuelve true si hay mas lineas en el result set por defecto al iniciar el rs esta en 0
                Salas salas1 = new Salas();
                salas1.setCodigo(rs.getString("CODIGO"));
                salas1.setNombre(rs.getString("NOMBRE"));
                salas1.setUbicacion(rs.getString("UBICACION"));
                salas1.setPiso(rs.getString("PISO"));
                salas.add(salas1);
            }
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salas;
    }

    public void actualizarSala(Salas salas){
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE SALAS SET CODIGO=?, NOMBRE=?, UBICACION=?, PISO=?"+"where CODIGO = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,salas.getCodigo());
            stmt.setString(2,salas.getNombre());
            stmt.setString(3,salas.getUbicacion());
            stmt.setString(4,salas.getPiso());
            stmt.setString(5,salas.getCodigo());

            stmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarSala(Salas salas){
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "DELETE FROM SALAS WHERE CODIGO = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,salas.getCodigo());
            stmt.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
