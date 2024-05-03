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
import valverde.ricardo.bl.Tripulacion;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class GTripulacion {
    @FXML
    TextField txtCodgo;
    @FXML
    TextField txtNombreClave;
    @FXML
    TextField txtGenero;
    @FXML
    TextField txtExp;
    @FXML
    TextField txtGraduacion;
    @FXML
    TextField txtLicencia;
    @FXML
    TextField txtPuesto;
    @FXML
    TextField txtNombre;
    @FXML
    TextField txtApellido;
    @FXML
    TextField txtNacionalidad;
    @FXML
    TextField txtCorreo;
    @FXML
    TextField txttelefono;
    @FXML
    TextField txtDireccion;

    ObservableList<Tripulacion> tripulacions;
    Gestor gestor = new Gestor();
    public TableView<Tripulacion> tbl;
    @FXML
    TableColumn<Tripulacion,String> TCodigo;
    @FXML
    TableColumn<Tripulacion, String> TTripulante;
    @FXML
    TableColumn<Tripulacion,String> Tapellido;
    @FXML
    TableColumn<Tripulacion,String> Tlicencia;
    @FXML
    TableColumn<Tripulacion,String> TExperiencia;
    @FXML
    TableColumn<Tripulacion, String> Ttelefono;
    @FXML
    TableColumn<Tripulacion,String> tCorreo;


    public void salir(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public void Cargar(MouseEvent mouseEvent) {
            Tripulacion tripulacion = tbl.getSelectionModel().getSelectedItem();
            if(tripulacion !=null){

                txtCodgo.setText(tripulacion.getCodigo());
                txtNombreClave.setText(""+tripulacion.getNombreClave()+"");
                txtGenero.setText(tripulacion.getGenero());
                txtLicencia.setText(tripulacion.getLicencia());
                txtPuesto.setText(tripulacion.getPuesto());
                txtNombre.setText(tripulacion.getNombre());
                txtApellido.setText(tripulacion.getApellidos());
                txtNacionalidad.setText(tripulacion.getNacionalidad());
                txtCorreo.setText(tripulacion.getCorreo());
                txttelefono.setText(tripulacion.getTelefono());
                txtDireccion.setText(tripulacion.getDireccion());

            }
            tbl.setItems(tripulacions);

    }

    public void registrar(ActionEvent actionEvent) {
        if(txtCodgo.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese su nombre");
            return;
        }
        if(txtNombreClave.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese la cantidad de Créditos");
            return;
        }
        //Para verificar que el combo no esta vacio se hace el getSelectionModel
        if(txtGenero.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }
        if(txtExp.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }
        if(txtGraduacion.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }

        if(txtLicencia.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }
        if(txtPuesto.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }
        if(txtNombre.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }
        if(txtApellido.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }
        if(txtNacionalidad.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }
        if(txtCorreo.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }
        if(txttelefono.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }
        if(txtDireccion.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el nombre del pais");
            return;
        }

        Gestor gestor = new Gestor();

        Tripulacion tripulacion1 = new Tripulacion(txtCodgo.getText(), txtNombreClave.getText(), txtGenero.getText(), Integer.valueOf(txtExp.getText()), Date.valueOf(txtGraduacion.getText()).toLocalDate(),txtLicencia.getText(),txtPuesto.getText(),txtNombre.getText(),txtApellido.getText(),txtNacionalidad.getText(),txtCorreo.getText(), txttelefono.getText(), txtDireccion.getText());
        gestor.insertarTripulante(tripulacion1);
        tripulacions.add(tripulacion1);
        tbl.setItems(tripulacions);
        showAlert(Alert.AlertType.INFORMATION,"Tripulante agregado Exitosamente !!!","Tripulante "+txtNombre.getText());
        txtCodgo.clear();
        txtNombreClave.clear();
        txtGenero.clear();
        txtExp.clear();
        txtGraduacion.clear();
        txtLicencia.clear();
        txtPuesto.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtNacionalidad.clear();
        txtCorreo.clear();
        txttelefono.clear();
        txtDireccion.clear();
    }
    public void initialize() throws SQLException, ClassNotFoundException {
        Gestor gestor = new Gestor();
        tripulacions = FXCollections.observableArrayList(gestor.listarTripulacion());
        TCodigo.setCellValueFactory(new PropertyValueFactory<Tripulacion, String>("Codigo"));
        TTripulante.setCellValueFactory(new PropertyValueFactory<Tripulacion, String>("Nombre"));
        Tapellido.setCellValueFactory(new PropertyValueFactory<Tripulacion,String>("apellidos"));
        Tlicencia.setCellValueFactory(new PropertyValueFactory<Tripulacion,String>("Licencia"));
        TExperiencia.setCellValueFactory(new PropertyValueFactory<Tripulacion,String>("añosExp"));
        tCorreo.setCellValueFactory(new PropertyValueFactory<Tripulacion,String>("correo"));
        tbl.setItems(tripulacions);
    }

    public void modificar(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Tripulacion tripulacion = tbl.getSelectionModel().getSelectedItem();
        Tripulacion tripulacion1 = new Tripulacion (txtCodgo.getText(),txtNombreClave.getText(), txtGenero.getText(),Integer.valueOf(txtExp.getText()),Date.valueOf(txtGraduacion.getText()).toLocalDate(),txtLicencia.getText(),txtPuesto.getText(),txtNombre.getText(),txtApellido.getText(), txtNacionalidad.getText(),txtCorreo.getText(), txttelefono.getText(),txtDireccion.getText());
        Gestor gestor = new Gestor();
        if(tripulacion ==null) {
            showAlert(Alert.AlertType.ERROR,"Error","Datos no modificados");
        }
        tripulacion = tripulacion1;

        gestor.actualizarTripulacion(tripulacion);
        initialize();
    }

    public void eliminar(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Tripulacion tripulacion = tbl.getSelectionModel().getSelectedItem();
        gestor.eliminarTripulacion(tripulacion);
        showAlert(Alert.AlertType.CONFIRMATION,"Se realiza su solicitud","Datos modificados");
        initialize();
    }
}
