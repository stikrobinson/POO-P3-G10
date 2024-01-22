/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo2p;

import ec.edu.espol.modelo.*;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author steve
 */
public class EditarEmprendedor {
    public static Emprendedor emprendedor;
    public static boolean nuevoEmprendedor;
    public static ArrayList<CuentaRedSocial> listaRedes;
    @FXML
    private GridPane gridPane;
    @FXML
    private Label titulo;
    @FXML
    private Label nomCedula;
    @FXML
    private TextField cedula;
    @FXML
    private TextField nombre;
    @FXML
    private TextField telefono;
    @FXML
    private TextField sitioWeb;
    @FXML
    private TextField nombreResponsable;
    @FXML
    private TextField descripcion;
    @FXML
    private TextField email;
    @FXML
    private TextField direccion;
    @FXML
    private TextField nombreCuenta;
    @FXML
    private ComboBox<RedSocial> redesSociales;
    
    public void initialize(){
        redesSociales.setItems(FXCollections.observableArrayList(RedSocial.values()));
        if(nuevoEmprendedor){
            titulo.setText("Nuevo Emprendedor");
        }else{
            titulo.setText("Editar Emprendedor");
            gridPane.getChildren().remove(nomCedula);
            gridPane.getChildren().remove(cedula);
            nombre.setText(emprendedor.getNombreEmprendimiento());
            telefono.setText(emprendedor.getTelefono());
            sitioWeb.setText(emprendedor.getSitio_web());
            nombreResponsable.setText(emprendedor.getNombre_responsable());
            descripcion.setText(emprendedor.getDescripcion());
            email.setText(emprendedor.getEmail());
            direccion.setText(emprendedor.getDireccion());
            listaRedes = emprendedor.getListaRedesSociales();
        }
    }
    
    @FXML
    private void guardar(){
        if(nuevoEmprendedor){
            try{
            boolean repetido = false;
            for(Emprendedor em: Emprendedor.getEmprendedores()){
                if(em.getCedula().equals(cedula.getText())){
                    repetido = true;
                }
            }
            if(repetido){
                showMessage(Alert.AlertType.ERROR, "Error al ingresar datos", "", "El número de cédula ya existe, ingrese uno nuevo.");
            }else{        
            Emprendedor e = new Emprendedor(cedula.getText(),telefono.getText(),email.getText(),descripcion.getText(),sitioWeb.getText(),nombre.getText(),nombreResponsable.getText(),descripcion.getText());
            e.setListaRedesSociales(listaRedes);
            Emprendedor.anadirEmprendedores(e);
            App.setRoot("AdministrarEmprendedores");
            }
            }catch(Exception e){
                showMessage(Alert.AlertType.ERROR, "Error al ingresar datos", "", "Ingrese los datos correctamente");
            }
        }else{
            try{
            emprendedor.setTelefono(telefono.getText());
            emprendedor.setEmail(email.getText());
            emprendedor.setDescripcion(descripcion.getText());
            emprendedor.setSitio_web(sitioWeb.getText());
            emprendedor.setNombreEmprendimiento(nombre.getText());
            emprendedor.setNombre_responsable(nombreResponsable.getText());
            emprendedor.setDescripcion(descripcion.getText());
            emprendedor.setListaRedesSociales(listaRedes);
            Emprendedor.actualizarEmprendedores(Emprendedor.getEmprendedores().indexOf(emprendedor), emprendedor);
            App.setRoot("AdministrarEmprendedores");
            }catch(Exception e){
                showMessage(Alert.AlertType.ERROR, "Error al ingresar datos", "", "Ingrese los datos correctamente");
           }
        }
    }
    
    @FXML
    private void cancelar() throws IOException{
        App.setRoot("AdministrarEmprendedores");
    }
    
    @FXML
    private void ingresarCuenta(){
        CuentaRedSocial rc = new CuentaRedSocial(nombreCuenta.getText(),redesSociales.getValue());
        listaRedes.add(rc);
        nombreCuenta.setText("");
        redesSociales.setValue(null);
    }
    
    @FXML
    private void verCuentas() throws IOException{
        VerCuentas.setListaRedes(listaRedes);
        App.setRoot("VerCuentas");
    }
    
    public static void setEmprendedor(Emprendedor e){
        emprendedor = e;
    }
    public static void setNuevoEmprendedor(boolean b){
        nuevoEmprendedor = b;
    }
    
    public void showMessage(Alert.AlertType tipo, String titulo, String encabezado, String mensaje) {
    Alert alerta = new Alert(tipo);
    alerta.setHeaderText(encabezado);
    alerta.setTitle(titulo);
    alerta.setContentText(mensaje);
    alerta.showAndWait();                         
    }
    
    
    public static void setListaRedes(ArrayList<CuentaRedSocial> c){
        listaRedes = c;
    }
    
}
