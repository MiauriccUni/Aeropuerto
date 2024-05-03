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
import valverde.ricardo.bl.Aeronaves;
import valverde.ricardo.bl.Pais;

import java.sql.SQLException;

public class Gaeronaves {

    public TextField txtplaca;
    public TextField txtMarca;
    public TextField txtModelo;
    public TextField txtCapacidad;

    public ObservableList<Aeronaves>aeronaves;


    public TableView<Aeronaves> tbl;
    @FXML
    TableColumn<Aeronaves, String> Tplaca ;
    @FXML
    TableColumn<Aeronaves,String> TMarca;
    @FXML
    TableColumn<Aeronaves,String> Tmodelo;
    @FXML
    TableColumn<Aeronaves,Integer> Tcapacidad;

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

    public void cargarAeronaves(MouseEvent mouseEvent) {
        Aeronaves aeronaves1 = tbl.getSelectionModel().getSelectedItem();
        if(aeronaves1 !=null){
            txtplaca.setText(aeronaves1.getPlaca());
            txtMarca.setText(""+aeronaves1.getMarcaFabrican()+"");
            txtModelo.setText(aeronaves1.getModelo());

        }
        tbl.setItems(aeronaves);
    }

    public void registrar(ActionEvent actionEvent) {
        if(txtplaca.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese su nombre");
            return;
        }
        if(txtMarca.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese la cantidad de Créditos");
            return;
        }
        //Para verificar que el combo no esta vacio se hace el getSelectionModel
        if(txtModelo.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }
        if(txtCapacidad.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }


        Gestor gestor = new Gestor();

        Aeronaves aeronaves1 = new Aeronaves(txtplaca.getText(), txtMarca.getText(), txtModelo.getText(),Integer.valueOf(txtCapacidad.getText()));

        gestor.insertarAeronave(aeronaves1);
        aeronaves.add(aeronaves1);
        tbl.setItems(aeronaves);
        showAlert(Alert.AlertType.INFORMATION,"Aeronave agregada Exitosamente !!!","Aeronave "+txtModelo.getText());
        txtModelo.clear();
        txtplaca.clear();
        txtMarca.clear();
        txtCapacidad.clear();
    }
    public void initialize() throws SQLException, ClassNotFoundException {
        Gestor gestor = new Gestor();
        aeronaves = FXCollections.observableArrayList(gestor.listarAeronaves());
        Tplaca.setCellValueFactory(new PropertyValueFactory<Aeronaves, String>("placa"));
        TMarca.setCellValueFactory(new PropertyValueFactory<Aeronaves, String>("marcaFabrican"));
        Tmodelo.setCellValueFactory(new PropertyValueFactory<Aeronaves,String>("modelo"));
        Tcapacidad.setCellValueFactory(new PropertyValueFactory<Aeronaves,Integer>("capacidad"));
        tbl.setItems(aeronaves);

    }

    public void modificar(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Aeronaves aeronaves1 = tbl.getSelectionModel().getSelectedItem();
        Aeronaves aeronaves2 = new Aeronaves (txtplaca.getText(),txtMarca.getText(), txtModelo.getText(),Integer.valueOf(txtCapacidad.getText()));
        Gestor gestor = new Gestor();
        if(aeronaves1 ==null) {
            showAlert(Alert.AlertType.ERROR,"Error","Datos no modificados");
        }
        aeronaves1 = aeronaves2;

        gestor.actualizarAeronave(aeronaves1);
        initialize();
    }

    public void eliminar(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Aeronaves aeronaves1 = tbl.getSelectionModel().getSelectedItem();
        gestor.eliminarAeronave(aeronaves1);
        showAlert(Alert.AlertType.CONFIRMATION,"Se realiza su solicitud","Datos modificados");
        initialize();

    }
}
