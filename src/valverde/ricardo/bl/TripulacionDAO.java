package valverde.ricardo.bl;

import java.sql.*;
import java.util.ArrayList;

public class TripulacionDAO {
    public void insertarPais(Tripulacion tripulacion){
        try {
            //creo una nueva instancia del archivo de configuracion
            Configuracion configuracion = new Configuracion();
            //lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConextion = configuracion.getStringConexion();
            String query = "INSERT INTO TRIPULACION (Codigo,NombreClave,Genero,Experiencia,Graduacion,Licencia,puesto,Nombre,apellidos,nacionalidad,correo,direccion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            conn = DriverManager.getConnection(strConextion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,tripulacion.getCodigo());
            stmt.setString(2,tripulacion.getNombreClave());
            stmt.setString(3,tripulacion.getGenero());
            stmt.setInt(4,tripulacion.getAñosExp());
            stmt.setDate(5, java.sql.Date.valueOf(tripulacion.getGraduacion()));
            stmt.setString(6,tripulacion.getLicencia());
            stmt.setString(7,tripulacion.getPuesto());
            stmt.setString(8,tripulacion.getNombre());
            stmt.setString(9,tripulacion.getApellidos());
            stmt.setString(10,tripulacion.getNacionalidad());
            stmt.setString(11,tripulacion.getCorreo());
            stmt.setString(12,tripulacion.getDireccion());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Tripulacion> listarTripulacion(){

        ArrayList<Tripulacion> tripulacion = new ArrayList<>();

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM TRIPULACION";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);//el rs almacena la informacion de la base de datos

            while (rs.next()){//rs.next() devuelve true si hay mas lineas en el result set por defecto al iniciar el rs esta en 0
                Tripulacion tripulacion1 = new Tripulacion();
                tripulacion1.setCodigo(rs.getString("Codigo"));
                tripulacion1.setNombreClave(rs.getString("NombreClave"));
                tripulacion1.setGenero(rs.getString("Genero"));
                tripulacion1.setAñosExp(rs.getInt("Experiencia"));
                tripulacion1.setGraduacion(rs.getDate("Graduacion").toLocalDate());
                tripulacion1.setLicencia(rs.getString("Licencia"));
                tripulacion1.setPuesto(rs.getString("puesto"));
                tripulacion1.setNombre(rs.getString("Nombre"));
                tripulacion1.setApellidos(rs.getString("apellidos"));
                tripulacion1.setNacionalidad(rs.getString("nacionalidad"));
                tripulacion1.setCorreo(rs.getString("correo"));
                tripulacion1.setDireccion(rs.getString("direccion"));
                tripulacion.add(tripulacion1);
            }
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tripulacion;
    }

    public void actualizarTripulacion(Tripulacion tripulacion){
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE TRIPULACION SET Codigo=?, NombreClave=?, Genero=?, Experiencia=?,Graduacion=?,Licencia=?,puesto=?,Nombre=?,apellidos=?,nacionalidad=?,correo=?,direccion=?"+"where CODIGO = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,tripulacion.getCodigo());
            stmt.setString(2,tripulacion.getNombreClave());
            stmt.setString(3,tripulacion.getGenero());
            stmt.setInt(4,tripulacion.getAñosExp());
            stmt.setDate(5, java.sql.Date.valueOf(tripulacion.getGraduacion()));
            stmt.setString(6,tripulacion.getLicencia());
            stmt.setString(7,tripulacion.getPuesto());
            stmt.setString(8,tripulacion.getNombre());
            stmt.setString(9,tripulacion.getApellidos());
            stmt.setString(10,tripulacion.getNacionalidad());
            stmt.setString(11,tripulacion.getCorreo());
            stmt.setString(12,tripulacion.getDireccion());
            stmt.setString(13,tripulacion.getCodigo());

            stmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarTripulacion(Tripulacion tripulacion){
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "DELETE FROM TRIPULACION WHERE CODIGO = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,tripulacion.getCodigo());
            stmt.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
