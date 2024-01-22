/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo2p;

import ec.edu.espol.modelo.*;
import java.io.IOException;
import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author steve
 */
public class AdministrarEmprendedores {
    @FXML
    private BorderPane borderPane;
    
    public void initialize(){
        TableView<Emprendedor> tabla = new TableView<Emprendedor>();
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn <Emprendedor,String> columnaCedula = new TableColumn<Emprendedor,String>("Cédula o RUC"); 
        columnaCedula.setCellValueFactory(new PropertyValueFactory<Emprendedor,String> ("cedula"));
        tabla.getColumns().add(columnaCedula);
        TableColumn <Emprendedor,String> columnaNombre = new TableColumn<Emprendedor,String>("Nombre"); 
        columnaNombre.setCellValueFactory(new PropertyValueFactory<Emprendedor,String> ("nombreEmprendimiento"));
        tabla.getColumns().add(columnaNombre);
        TableColumn <Emprendedor,String> columnaTelefono = new TableColumn<Emprendedor,String>("Teléfono"); 
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<Emprendedor,String> ("telefono"));
        tabla.getColumns().add(columnaTelefono);
        TableColumn <Emprendedor,String> columnaEmail = new TableColumn<Emprendedor,String>("Email"); 
        columnaEmail.setCellValueFactory(new PropertyValueFactory<Emprendedor,String> ("email"));
        tabla.getColumns().add(columnaEmail);
        for(Emprendedor e: Emprendedor.getEmprendedores()){
            tabla.getItems().add(e);
        }
        tabla.getSelectionModel().selectFirst();
        borderPane.setCenter(tabla);
    }
    
    @FXML
    private void volver() throws IOException{
    App.setRoot("MenuPrincipal");
    }
    @FXML
    private void nuevoEmprendedor() throws IOException{
        EditarEmprendedor.setNuevoEmprendedor(true);
        App.setRoot("EditarEmprendedor");
    }
    @FXML
    private void editarEmprendedor() throws IOException{
       EditarEmprendedor.setNuevoEmprendedor(false);
       EditarEmprendedor.setEmprendedor(seleccion());
       App.setRoot("EditarEmprendedor");
       
    }
      private Emprendedor seleccion(){
      TableView tabla = (TableView) borderPane.getCenter();
      TableView.TableViewSelectionModel<Emprendedor> selectionModel = tabla.getSelectionModel();
      ObservableList<Emprendedor> seleccionados = selectionModel.getSelectedItems();
      return seleccionados.get(0);
    }
    
    
}
    
