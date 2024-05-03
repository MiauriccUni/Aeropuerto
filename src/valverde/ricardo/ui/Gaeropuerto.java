package valverde.ricardo.ui;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import valverde.ricardo.Gestor.Gestor;
import valverde.ricardo.bl.Aeropuertos;
import valverde.ricardo.bl.Pais;

import java.sql.SQLException;

public class Gaeropuerto {

    public TextField txtCodigoAeropuerto;
    public TextField txtNombreAeropuerto;
    public ComboBox CPais;

    public ObservableList<Aeropuertos>aeropuertos;

    public ObservableList<Pais>pais;
    private Gestor gestor = new Gestor();
    @FXML
    TableView<Aeropuertos> tblaeros;
    @FXML
    TableColumn <Aeropuertos, String> TCodigoAeropuerto;
    @FXML
    TableColumn <Aeropuertos, String> Tnobreaeropuerto;
    @FXML
    TableColumn <Aeropuertos, String>Tpais;
    public void salir(ActionEvent actionEvent) {
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public void registrarAeropuerto(ActionEvent actionEvent) {
        if(txtCodigoAeropuerto.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese su nombre");
            return;
        }
        if(txtNombreAeropuerto.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese la cantidad de Créditos");
            return;
        }
        //Para verificar que el combo no esta vacio se hace el getSelectionModel
        if(CPais.getSelectionModel().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }

        Pais pais1 = (Pais) CPais.getValue();
        Gestor gestor = new Gestor();

        Aeropuertos aeropuertos1 = new Aeropuertos(txtCodigoAeropuerto.getText(),txtNombreAeropuerto.getText(),pais1);
        gestor.insertarAeropuerto(aeropuertos1);
        aeropuertos.add(aeropuertos1);
        tblaeros.setItems(aeropuertos);
        showAlert(Alert.AlertType.CONFIRMATION,"Aeropuerto Agregado Exitosamente !!!","Aeropuerto "+txtNombreAeropuerto.getText());
        txtNombreAeropuerto.clear();
        txtCodigoAeropuerto.clear();

    }
    public void Cargar(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        Aeropuertos aeropuertos1 = tblaeros.getSelectionModel().getSelectedItem();
        if(aeropuertos1 !=null){
            txtCodigoAeropuerto.setText(aeropuertos1.getCodigo());
            txtNombreAeropuerto.setText(""+aeropuertos1.getNombreAero()+"");

        }
        tblaeros.setItems(aeropuertos);

    }
    public void modificarAeropuerto(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Aeropuertos aeropuertos1 = tblaeros.getSelectionModel().getSelectedItem();

        Aeropuertos aeropuertos2 = new Aeropuertos (txtCodigoAeropuerto.getText(),txtNombreAeropuerto.getText());

        Gestor gestor = new Gestor();
        if(aeropuertos1 ==null) {
            showAlert(Alert.AlertType.ERROR,"Error","Datos no modificados");
        }
        aeropuertos1 = aeropuertos2;

        gestor.actualizarAeropuerto(aeropuertos1);
        showAlert(Alert.AlertType.INFORMATION,"Exitoso","Los datos fueron modificados ");
        initialize();
        gestor.listarPais();

    }
    public void EliminarAeropuerto(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Aeropuertos aeropuertos1 = tblaeros.getSelectionModel().getSelectedItem();
        gestor.eliminarAeropuerto(aeropuertos1);
        showAlert(Alert.AlertType.CONFIRMATION,"Se realiza su solicitud","Datos modificados");
        initialize();

    }
    public void initialize() throws SQLException, ClassNotFoundException {
        Gestor gestor=new Gestor();
        aeropuertos= FXCollections.observableArrayList(gestor.listarAeropuerto());
        TCodigoAeropuerto.setCellValueFactory(new PropertyValueFactory<Aeropuertos,String>("codigo"));
        Tnobreaeropuerto.setCellValueFactory(new PropertyValueFactory<Aeropuertos,String>("nombreAero"));
        //Cuando quiero mandar el valor a un combo box
        Tpais.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPais().getIde()));

        tblaeros.setItems(aeropuertos);

        pais= FXCollections.observableArrayList(gestor.listarPais());
        CPais.setItems(pais);

        Callback<ListView<Pais>, ListCell<Pais>> cellFactory = new Callback<>() {

            @Override
            public ListCell<Pais> call(ListView<Pais> l) {
                return new ListCell<>() {

                    @Override
                    protected void updateItem(Pais item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(item.getPais()+ "    " + item.getPais());
                        }
                    }
                };
            }
        };

        CPais.setButtonCell(cellFactory.call(null));
        CPais.setCellFactory(cellFactory);
    }

}
