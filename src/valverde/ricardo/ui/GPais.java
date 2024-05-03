package valverde.ricardo.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import valverde.ricardo.Gestor.Gestor;
import valverde.ricardo.bl.Aeropuertos;
import valverde.ricardo.bl.Pais;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GPais {

    public TextField txtPais;
    public TextField txtAbreviatura;
    public TextField txtID;

    public ObservableList<Pais> pais;

    public TableView<Pais> tblPaises;
    @FXML
    TableColumn<Pais, String> Tpais;
    @FXML
    TableColumn<Pais, String> Tabreviatura;
    @FXML
    TableColumn<Pais,String> TID;

    private Gestor gestor = new Gestor();


    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
    public void salir(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }


    @FXML
    private void cargarListapaises() throws Exception{
        Pais pais1 = tblPaises.getSelectionModel().getSelectedItem();
        if(pais1 !=null){

            txtID.setText(pais1.getIde());
            txtPais.setText(""+pais1.getPais()+"");
            txtAbreviatura.setText(pais1.getAbreviatura());
        }
        tblPaises.setItems(pais);

    }
     @FXML
     private void modificarPais() throws Exception {

        Pais pais1 = tblPaises.getSelectionModel().getSelectedItem();
        Pais pais2 = new Pais (txtID.getText(),txtPais.getText(), txtAbreviatura.getText());
        Gestor gestor = new Gestor();
         if(pais1 ==null) {
             showAlert(Alert.AlertType.ERROR,"Error","Datos no modificados");
         }
         pais1 = pais2;

         gestor.actualizarPais(pais1);
         initialize();
     }

     @FXML
     private void EliminarPais() throws Exception {
         Pais pais1 = tblPaises.getSelectionModel().getSelectedItem();
         gestor.eliminarPais(pais1);
         showAlert(Alert.AlertType.CONFIRMATION,"Se realiza su solicitud","Datos modificados");
         initialize();
     }


    public void initialize() throws SQLException, ClassNotFoundException {
        Gestor gestor = new Gestor();
        pais = FXCollections.observableArrayList(gestor.listarPais());
        Tpais.setCellValueFactory(new PropertyValueFactory<Pais, String>("pais"));
        Tabreviatura.setCellValueFactory(new PropertyValueFactory<Pais, String>("abreviatura"));
        TID.setCellValueFactory(new PropertyValueFactory<Pais,String>("ide"));
        tblPaises.setItems(pais);
    }
    public void btnRegistroLineas(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("lineas.fxml"));
            Parent root = loader.load();
            Glineas controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        }catch (IOException ex){
            Logger.getLogger(Glineas.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void registrodeaeronaves(ActionEvent actionEvent) {

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("aeronaves.fxml"));
            Parent root = loader.load();
            Gaeronaves controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        }catch (IOException ex){
            Logger.getLogger(Gaeronaves.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void btnRegistroAe(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("aeropuerto.fxml"));
            Parent root = loader.load();
            Gaeropuerto controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        }catch (IOException ex){
            Logger.getLogger(Gaeropuerto.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void registrarPais(ActionEvent actionEvent) {
        if(txtID.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese su nombre");
            return;
        }
        if(txtPais.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese la cantidad de Créditos");
            return;
        }
        //Para verificar que el combo no esta vacio se hace el getSelectionModel
        if(txtAbreviatura.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }

        Gestor gestor = new Gestor();

        Pais pais1 = new Pais(txtID.getText(), txtPais.getText(), txtAbreviatura.getText());
        gestor.insertarPais(pais1);
        pais.add(pais1);
        tblPaises.setItems(pais);
        showAlert(Alert.AlertType.INFORMATION,"Pais Agregado Exitosamente !!!","Pais "+txtPais.getText());
        txtPais.clear();
        txtAbreviatura.clear();
    }

    public void registroSalas(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("salas.fxml"));
            Parent root = loader.load();
            CSalas controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        }catch (IOException ex){
            Logger.getLogger(CSalas.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void registroTrupulacion(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("tripulacion.fxml"));
            Parent root = loader.load();
            GTripulacion controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        }catch (IOException ex){
            Logger.getLogger(GTripulacion.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void registroUsuario(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("usuarios.fxml"));
            Parent root = loader.load();
            Gusuario controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        }catch (IOException ex){
            Logger.getLogger(Gusuario.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
