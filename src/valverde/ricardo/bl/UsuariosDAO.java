package valverde.ricardo.bl;

import java.sql.*;
import java.util.ArrayList;

public class UsuariosDAO {
    public void insertarUsuario(Usuarios usuarios){
        try {
            //creo una nueva instancia del archivo de configuracion
            Configuracion configuracion = new Configuracion();
            //lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConextion = configuracion.getStringConexion();
            String query = "INSERT INTO USUARIOS (CEDULA,NOMBRE,CORREO,CONTRASEÑA) VALUES(?,?,?,?)";
            conn = DriverManager.getConnection(strConextion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,usuarios.getCedula());
            stmt.setString(2,usuarios.getNombre());
            stmt.setString(3,usuarios.getCorreo());
            stmt.setString(4,usuarios.getContraseña());
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Usuarios> listarUsuarios(){

        ArrayList<Usuarios> usuarios = new ArrayList<>();

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM USUARIOS";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);//el rs almacena la informacion de la base de datos

            while (rs.next()){//rs.next() devuelve true si hay mas lineas en el result set por defecto al iniciar el rs esta en 0
                Usuarios usuarios1 = new Usuarios();
                usuarios1.setCedula(rs.getString("CEDULA"));
                usuarios1.setNombre(rs.getString("NOMBRE"));
                usuarios1.setCorreo(rs.getString("CORREO"));
                usuarios1.setContraseña(rs.getString("CONTRASEÑA"));
                usuarios.add(usuarios1);
            }
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    public void actualizarUsuarios(Usuarios usuarios){
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE USUARIOS SET  CEDULA=?, NOMBRE=?, CORREO=? , CONTRASEÑA=?"+"where CEDULA = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,usuarios.getNombre());
            stmt.setString(2,usuarios.getCedula());
            stmt.setString(3,usuarios.getCorreo());
            stmt.setString(4,usuarios.getContraseña());
            stmt.setString(5,usuarios.getCedula());
            stmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarUsuario(Usuarios usuarios){
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "DELETE FROM USUARIOS WHERE CEDULA = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,usuarios.getCedula());
            stmt.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
