package valverde.ricardo.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import valverde.ricardo.Gestor.Gestor;
import valverde.ricardo.bl.Salas;

import java.sql.SQLException;

public class CSalas {
    public TextField txtcodigo;
    public TextField txtnombre;
    public TextField txtubicacion;
    public TextField txpiso;
    public TableView<Salas> tblPaises;
    public TableColumn<Salas,String> TCodigo;
    public TableColumn<Salas,String> Tnombre;
    public TableColumn<Salas,String> Tubicacion;
    public TableColumn<Salas,String> Tpiso;
    public ObservableList<Salas> salas;
    private Gestor gestor = new Gestor();



    public void salir(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }

    public void cargar(MouseEvent mouseEvent) {
        Salas salas1 = tblPaises.getSelectionModel().getSelectedItem();
        if(salas1 !=null){
            txtcodigo.setText(salas1.getCodigo());
            txtnombre.setText(""+salas1.getNombre()+"");
            txtubicacion.setText(salas1.getUbicacion());
            txpiso.setText(salas1.getPiso());
        }
        tblPaises.setItems(salas);

    }

    public void registrar(ActionEvent actionEvent) {
        if(txpiso.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese su nombre");
            return;
        }
        if(txtcodigo.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese la cantidad de Créditos");
            return;
        }
        //Para verificar que el combo no esta vacio se hace el getSelectionModel
        if(txtnombre.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }
        if(txtubicacion.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }

        Gestor gestor = new Gestor();

        Salas salas1 = new Salas(txtcodigo.getText(), txtnombre.getText(), txtubicacion.getText(), txpiso.getText());
        gestor.insertarSala(salas1);
        salas.add(salas1);
        tblPaises.setItems(salas);
        showAlert(Alert.AlertType.INFORMATION,"Sala agregada Exitosamente !!!","Sala "+txtnombre.getText());
        txtubicacion.clear();
        txtnombre.clear();
        txtcodigo.clear();
        txpiso.clear();
    }
    public void initialize() throws SQLException, ClassNotFoundException {
        Gestor gestor = new Gestor();
        salas = FXCollections.observableArrayList(gestor.listarSala());
        TCodigo.setCellValueFactory(new PropertyValueFactory<Salas, String>("Codigo"));
        Tnombre.setCellValueFactory(new PropertyValueFactory<Salas, String>("nombre"));
        Tubicacion.setCellValueFactory(new PropertyValueFactory<Salas,String>("ubicacion"));
        Tpiso.setCellValueFactory(new PropertyValueFactory<Salas,String>("piso"));
        tblPaises.setItems(salas);
    }

    public void modificar(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Salas salas1 = tblPaises.getSelectionModel().getSelectedItem();
        Salas salas2 = new Salas (txtcodigo.getText(),txtnombre.getText(), txtubicacion.getText(),txpiso.getText());
        Gestor gestor = new Gestor();
        if(salas1 ==null) {
            showAlert(Alert.AlertType.ERROR,"Error","Datos no modificados");
        }
        salas1 = salas2;

        gestor.actualizarSala(salas1);
        initialize();

    }

    public void Eliminar(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Salas salas1 = tblPaises.getSelectionModel().getSelectedItem();
        gestor.eliminarSala(salas1);
        showAlert(Alert.AlertType.CONFIRMATION,"Se realiza su solicitud","Datos modificados");
        initialize();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

}
