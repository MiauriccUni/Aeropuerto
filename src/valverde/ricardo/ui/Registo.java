package valverde.ricardo.ui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import valverde.ricardo.Gestor.Gestor;
import valverde.ricardo.bl.Usuarios;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Registo {
    public TextField txtCedula;
    public TextField txtNombre;
    public TextField txtCorreo;
    public TextField txtPassword;
    ObservableList<Usuarios> usuarios;

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
        showAlert(Alert.AlertType.INFORMATION,"usuario Agregado Exitosamente !!!","Usuario  "+txtNombre.getText());
        txtNombre.clear();
        txtCedula.clear();
        txtPassword.clear();
        txtCorreo.clear();
        

    }

    public void modificarUsuario(ActionEvent actionEvent) {
    }

    public void eliminarUsuario(ActionEvent actionEvent) {
    }
}
