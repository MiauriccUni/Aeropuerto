package valverde.ricardo.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


public class main extends Application {
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setTitle("Formulario de Ingreso de Cursos Aplicacion JavaFX");
        stage.setScene(new Scene(root,700,550));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

