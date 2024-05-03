package valverde.ricardo.bl;

import java.sql.*;
import java.util.ArrayList;

public class LineasAereasDAO {
    public void insertarLineaAerea(LineasAereas lineasAereas) {
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "INSERT INTO LINEASAEREAS (CEDULAJURI,NOMBREAERO,NOMBREDUE,PAIS) VALUES(?,?,?,?)";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,lineasAereas.getCedulaJuri());
            stmt.setString(2,lineasAereas.getNombreAero());
            stmt.setString(3,lineasAereas.getNombreDue());
            stmt.setString(4,lineasAereas.getPais().getIde());
            stmt.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<LineasAereas> listarLineasAereas() {
        ArrayList<LineasAereas> lineasAereas= new ArrayList<LineasAereas>();
        try {
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            String query = "SELECT * FROM LINEASAEREAS";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);// el rs almacena la información de la base de datos.

            while (rs.next()) { //rs.next devuelve true si hay más líneas en el result set. por defecto, al iniciar el ciclo, el rs está en la línea 0.
                LineasAereas lineasAereas1 = new LineasAereas();
                lineasAereas1.setCedulaJuri(rs.getString("cedulaJuri"));
                lineasAereas1.setNombreAero(rs.getString("nombreAero"));
                lineasAereas1.setNombreDue(rs.getString("nombreDue"));
                PaisDAO paisDAO = new PaisDAO();
                lineasAereas1.setPais(paisDAO.obtenerPais(rs.getString("PAIS")));
                lineasAereas.add(lineasAereas1);
            }
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return lineasAereas;
    }

    public void actualizarLineasAereas(LineasAereas tmpLineasAereas) {
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
        String query = "UPDATE LINEASAEREAS SET CEDULAJURI=?,NOMBREAERO=?,NOMBREDUE=?" +
                    "where CEDULAJURI = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,tmpLineasAereas.getCedulaJuri());
            stmt.setString(2,tmpLineasAereas.getNombreAero());
            stmt.setString(3,tmpLineasAereas.getNombreDue());
            stmt.setString(4,tmpLineasAereas.getCedulaJuri());
            stmt.execute();
        }
        catch (SQLException e){
            e.printStackTrace();;

        }
        catch (Exception e){
            e.printStackTrace();;
        }
    }

    public void eliminarLienasAereas(LineasAereas tmpLineas){
        try{
            Configuracion configuracion= new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "DELETE FROM LINEASAEREAS WHERE CEDULAJURI = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setString(1,tmpLineas.getCedulaJuri());
            stmt.execute();
        }
        catch (SQLException e){
            e.printStackTrace();;

        }
        catch (Exception e){
            e.printStackTrace();;
        }
    }



}
