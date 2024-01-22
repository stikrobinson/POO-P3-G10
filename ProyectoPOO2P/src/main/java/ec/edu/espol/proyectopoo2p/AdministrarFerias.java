/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo2p;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ec.edu.espol.modelo.*;
import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author steve
 */
public class AdministrarFerias {
    @FXML
    private BorderPane borderPane;
    
    public void initialize(){
        TableView<Feria> tabla = new TableView<Feria>();
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn <Feria,Integer> columnaCodigo = new TableColumn<Feria,Integer>("Código"); 
        columnaCodigo.setCellValueFactory(new PropertyValueFactory<Feria,Integer> ("codigo"));
        tabla.getColumns().add(columnaCodigo);
        TableColumn <Feria,String> columnaNombre = new TableColumn<Feria,String>("Nombre"); 
        columnaNombre.setCellValueFactory(new PropertyValueFactory<Feria,String> ("nombre"));
        tabla.getColumns().add(columnaNombre);
        TableColumn <Feria,LocalDate> columnaFechaInicio = new TableColumn<Feria,LocalDate>("Fecha Inicio"); 
        columnaFechaInicio.setCellValueFactory(new PropertyValueFactory<Feria,LocalDate> ("fechaInicio"));
        tabla.getColumns().add(columnaFechaInicio);
        TableColumn <Feria,String> columnaLugar = new TableColumn<Feria,String>("Lugar"); 
        columnaLugar.setCellValueFactory(new PropertyValueFactory<Feria,String> ("lugar"));
        tabla.getColumns().add(columnaLugar);
        TableColumn <Feria,Integer> columnaCantAuspiciantes = new TableColumn<Feria,Integer>("Cantidad Auspiciantes"); 
        columnaCantAuspiciantes.setCellValueFactory(new PropertyValueFactory<Feria,Integer> ("cantidadAuspiciantes"));
        tabla.getColumns().add(columnaCantAuspiciantes);
        TableColumn <Feria,Integer> columnaCantEmprendedores = new TableColumn<Feria,Integer>("Cantidad Emprendedores"); 
        columnaCantEmprendedores.setCellValueFactory(new PropertyValueFactory<Feria,Integer> ("cantidadEmprendedores"));
        tabla.getColumns().add(columnaCantEmprendedores);
        for(Feria f: Feria.getFerias()){
            f.setCantidadAuspiciantes();
            f.setCantidadEmprendedores();
            tabla.getItems().add(f);
        }
        tabla.getSelectionModel().selectFirst();
        borderPane.setCenter(tabla);
    }
    
    @FXML
    private void detalles()throws IOException{  
      MostrarDetalles.setFeria(seleccion());
      App.setRoot("MostrarDetalles");
    }
    
    @FXML
    private void nuevaFeria() throws IOException{
      EditarFeria.setNuevaFeria(true);
      App.setRoot("EditarFeria");
    }
    
    @FXML
    private void editar() throws IOException{ 
      if(seleccion().getFechaInicio().isBefore(LocalDate.now())){
          showMessage(AlertType.ERROR,"No puede editar", "", "No puede editar la feria porque ya ha empezado.");
      }else{
      EditarFeria.setNuevaFeria(false); 
      EditarFeria.setFeria(seleccion());
      App.setRoot("EditarFeria");
      }
    }
    
    @FXML
    private void verEmprendedores() throws IOException{
      MostrarEmprendedores.setMostrarAuspiciantes(false);
      MostrarEmprendedores.setFeria(seleccion());
      App.setRoot("MostrarEmprendedores");
    }
    
    @FXML
    private void verAuspiciantes() throws IOException{
            MostrarEmprendedores.setMostrarAuspiciantes(true);
      MostrarEmprendedores.setFeria(seleccion());
      App.setRoot("MostrarEmprendedores");
    }
    
    @FXML
    private void verStands(){
      MostrarStands.setFeria(seleccion());
      MostrarStands.setVolverAFerias(true);
            try{
            App.setRoot("MostrarStands");
            }catch(Exception ex){
             System.out.println(ex.getMessage());
             }        
     }
    
    
    @FXML
    private void volver() throws IOException{
    App.setRoot("MenuPrincipal");
    }
    
    private Feria seleccion(){
      TableView tabla = (TableView) borderPane.getCenter();
      TableViewSelectionModel<Feria> selectionModel = tabla.getSelectionModel();
      ObservableList<Feria> seleccionados = selectionModel.getSelectedItems();
      return seleccionados.get(0);
    }
    
    public void showMessage(Alert.AlertType tipo, String titulo, String encabezado, String mensaje) {
    Alert alerta = new Alert(tipo);
    alerta.setHeaderText(encabezado);
    alerta.setTitle(titulo);
    alerta.setContentText(mensaje);
    alerta.showAndWait();                         
    }
}
