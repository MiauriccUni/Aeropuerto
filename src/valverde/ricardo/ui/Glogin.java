package valverde.ricardo.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Glogin {
    @FXML
    private TextField txtCorreo;
    @FXML
    private PasswordField txtPassword;

    public void validarDatos(ActionEvent actionEvent) {
        String contraseña = "1234";
        String correo = "ricardo@gmail.com";
        if (txtCorreo.getText().equals(correo) && txtPassword.getText().equals(contraseña)){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("pais.fxml"));
                Parent root = loader.load();
                GPais controlador = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();
            }catch (IOException ex){
                Logger.getLogger(GPais.class.getName()).log(Level.SEVERE,null,ex);
            }
        }else {showAlert(Alert.AlertType.ERROR,"Error","Su usuario no esta registrado");

            try{


                try {
                    //Ponemos a "Dormir" el programa durante los ms que queremos
                     Thread.sleep(2*1000);


                }catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                FXMLLoader loader = new FXMLLoader(getClass().getResource("registo.fxml"));
                Parent root = loader.load();
                Registo controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();


            }catch (IOException ex){
                Logger.getLogger(Registo.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
