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
import valverde.ricardo.bl.LineasAereas;
import valverde.ricardo.bl.Pais;

import java.sql.SQLException;

public class Glineas {

    public TextField txtCedulaJuri;
    public TextField txtNombreAerolinea;
    public TextField txtNombreD;
    public ComboBox CPais;
    @FXML
    TableView<LineasAereas> tblaerolineas;
    @FXML
    TableColumn<LineasAereas, String> TCedulaJuri;
    @FXML
    TableColumn<LineasAereas, String> TnombreAerolinea;
    @FXML
    TableColumn<LineasAereas,String> Tdueno;
    @FXML
    TableColumn<LineasAereas, String> Tpais;

    private Gestor gestor = new Gestor();

    public ObservableList<LineasAereas>lineasAereas;

    public ObservableList<Pais>pais;

    public void registrar(ActionEvent actionEvent) {
        if(txtCedulaJuri.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese su nombre");
            return;
        }
        if(txtNombreAerolinea.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese la cantidad de Créditos");
            return;
        }
        if(txtNombreD.getText().isEmpty()) {
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

        LineasAereas lineasAereas1 = new LineasAereas(txtCedulaJuri.getText(),txtNombreAerolinea.getText(),txtNombreD.getText(),pais1);
        gestor.insertarAerolinea(lineasAereas1);
        lineasAereas.add(lineasAereas1);
        tblaerolineas.setItems(lineasAereas);
        showAlert(Alert.AlertType.CONFIRMATION,"Aeropuerto Agregado Exitosamente !!!","Aeropuerto "+txtNombreAerolinea.getText());
        txtNombreD.clear();
        txtNombreAerolinea.clear();
        txtCedulaJuri.clear();

    }

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
    public void cargarListaAerolineas(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        LineasAereas lineasAereas1 = tblaerolineas.getSelectionModel().getSelectedItem();
        if(lineasAereas1 !=null){
            txtCedulaJuri.setText(lineasAereas1.getCedulaJuri());
            txtNombreAerolinea.setText(""+ lineasAereas1.getNombreAero()+"");
            gestor.listarLineasaereas();
        }
        tblaerolineas.setItems(lineasAereas);

    }


    public void modificarAerolienea(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        LineasAereas lineasAereas1 = tblaerolineas.getSelectionModel().getSelectedItem();

        LineasAereas lineasAereas2 = new LineasAereas (txtCedulaJuri.getText(),txtNombreAerolinea.getText(),txtNombreD.getText());


        Gestor gestor = new Gestor();
        if(lineasAereas1 ==null) {
            showAlert(Alert.AlertType.ERROR,"Error","Datos no modificados");
        }
        lineasAereas1 = lineasAereas2;

        gestor.actualizarLineasAereas(lineasAereas1);
        showAlert(Alert.AlertType.INFORMATION,"Exitoso","Los datos fueron modificados ");
        initialize();
        gestor.listarPais();

    }

    public void EliminarAeroliena(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        LineasAereas lineasAereas1 = tblaerolineas.getSelectionModel().getSelectedItem();
        gestor.eliminarLineaAerea(lineasAereas1);
        showAlert(Alert.AlertType.CONFIRMATION,"Se realiza su solicitud","Datos modificados");
        initialize();
    }
    public void initialize() throws SQLException, ClassNotFoundException {
        Gestor gestor=new Gestor();
        lineasAereas= FXCollections.observableArrayList(gestor.listarLineasaereas());
        TCedulaJuri.setCellValueFactory(new PropertyValueFactory<LineasAereas,String>("cedulaJuri"));
        TnombreAerolinea.setCellValueFactory(new PropertyValueFactory<LineasAereas,String>("nombreAero"));
        Tdueno.setCellValueFactory(new PropertyValueFactory<LineasAereas,String>("nombreDue"));
        //Cuando quiero mandar el valor a un combo box
        Tpais.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPais().getIde()));
        tblaerolineas.setItems(lineasAereas);

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
