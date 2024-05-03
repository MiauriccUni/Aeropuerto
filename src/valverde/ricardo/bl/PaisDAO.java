package valverde.ricardo.bl;

import java.sql.*;
import java.util.ArrayList;

public class PaisDAO {
    public void insertarPais(Pais pais){
        try {
            //creo una nueva instancia del archivo de configuracion
            Configuracion configuracion = new Configuracion();
            //lo lee del archivo de configuracion
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            String strConextion = configuracion.getStringConexion();
            String query = "INSERT INTO PAIS (IDPAIS,PAIS,ABREVIATURA) VALUES(?,?,?)";
            conn = DriverManager.getConnection(strConextion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,pais.getIde());
            stmt.setString(2,pais.getPais());
            stmt.setString(3,pais.getAbreviatura());
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Pais> listarPais(){

        ArrayList<Pais> pais = new ArrayList<>();

        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM PAIS";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);//el rs almacena la informacion de la base de datos

            while (rs.next()){//rs.next() devuelve true si hay mas lineas en el result set por defecto al iniciar el rs esta en 0
                Pais pais1 = new Pais();
                pais1.setIde(rs.getString("IDPAIS"));
                pais1.setPais(rs.getString("PAIS"));
                pais1.setAbreviatura(rs.getString("ABREVIATURA"));
                pais.add(pais1);
            }
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pais;
    }
    public void actualizarPais(Pais pais){
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE PAIS SET IDPAIS=?, PAIS=?, ABREVIATURA=?"+"where IDPAIS = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,pais.getIde());
            stmt.setString(2,pais.getPais());
            stmt.setString(3,pais.getAbreviatura());
            stmt.setString(4,pais.getIde());
            stmt.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPais(Pais pais){
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "DELETE FROM PAIS WHERE IDPAIS = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,pais.getIde());
            stmt.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pais obtenerPais(String identificacion){
        Pais pais = new Pais();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM PAIS WHERE IDPAIS = ?";
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,identificacion);
            rs = stmt.executeQuery();

            while (rs.next()) { //rs.next devuelve true si hay más líneas en el result set. por defecto, al iniciar el ciclo, el rs está en la línea 0.
                pais.setIde(rs.getString("IDPAIS"));
                pais.setPais(rs.getString("pais"));
                pais.setAbreviatura(rs.getString("abreviatura"));
            }
            conn.close();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return pais;
    }


}
