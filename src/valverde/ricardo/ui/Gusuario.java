package valverde.ricardo.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import valverde.ricardo.Gestor.Gestor;
import valverde.ricardo.bl.Pais;
import valverde.ricardo.bl.Usuarios;

import java.sql.SQLException;

public class Gusuario {
    public TextField txtCedula;
    public TextField txtNombre;
    public TextField txtCorreo;
    public TextField txtPassword;
    ObservableList<Usuarios> usuarios;
    public TableView<Usuarios>tblPersonas;
    @FXML
    TableColumn<Usuarios,String> colUno;
    @FXML
    TableColumn<Usuarios,String>colDos;
    @FXML
    TableColumn<Usuarios,String>colTres;
    @FXML
    TableColumn<Usuarios,String>colCuatro;
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

    public void cargarUsuario(MouseEvent mouseEvent) {
        Usuarios usuarios1 = tblPersonas.getSelectionModel().getSelectedItem();
        if(usuarios1 !=null){
            txtCedula.setText(usuarios1.getCedula());
            txtNombre.setText(""+usuarios1.getNombre()+"");
            txtCorreo.setText(usuarios1.getCorreo());
            txtPassword.setText(usuarios1.getContraseña());
        }
        tblPersonas.setItems(usuarios);
    }

    public void registrarUsuario(ActionEvent actionEvent) {
        if(txtCedula.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese su nombre");
            return;
        }
        if(txtNombre.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese la cantidad de Créditos");
            return;
        }
        //Para verificar que el combo no esta vacio se hace el getSelectionModel
        if(txtCorreo.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }
        if(txtPassword.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }

        Gestor gestor = new Gestor();

        Usuarios usuarios1 = new Usuarios(txtCedula.getText(), txtNombre.getText(), txtCorreo.getText(),txtPassword.getText());

        gestor.insertarUsuario(usuarios1);
        usuarios.add(usuarios1);
        tblPersonas.setItems(usuarios);
        showAlert(Alert.AlertType.INFORMATION,"usuario Agregado Exitosamente !!!","Usuario  "+txtNombre.getText());
        txtNombre.clear();
        txtCedula.clear();
        txtPassword.clear();
        txtCorreo.clear();

    }
    public void initialize() throws SQLException, ClassNotFoundException {
        Gestor gestor = new Gestor();
        usuarios = FXCollections.observableArrayList(gestor.listarUsuarios());
        colUno.setCellValueFactory(new PropertyValueFactory<Usuarios, String>("nombre"));
        colDos.setCellValueFactory(new PropertyValueFactory<Usuarios, String>("cedula"));
        colTres.setCellValueFactory(new PropertyValueFactory<Usuarios,String>("correo"));
        colCuatro.setCellValueFactory(new PropertyValueFactory<Usuarios,String>("contraseña"));
        tblPersonas.setItems(usuarios);
    }

    public void modificarUsuario(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Usuarios usuarios1 = tblPersonas.getSelectionModel().getSelectedItem();
        Usuarios usuarios2 = new Usuarios (txtCedula.getText(),txtNombre.getText(), txtCorreo.getText(),txtPassword.getText());
        Gestor gestor = new Gestor();
        if(usuarios1 ==null) {
            showAlert(Alert.AlertType.ERROR,"Error","Datos no modificados");
        }
        usuarios1 = usuarios2;

        gestor.actualizarUsuarios(usuarios1);
        initialize();
    }

    public void eliminarUsuario(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Usuarios usuarios1 = tblPersonas.getSelectionModel().getSelectedItem();
        gestor.eliminarUsuario(usuarios1);
        showAlert(Alert.AlertType.CONFIRMATION,"Se realiza su solicitud","Datos modificados");
        initialize();
    }
}
