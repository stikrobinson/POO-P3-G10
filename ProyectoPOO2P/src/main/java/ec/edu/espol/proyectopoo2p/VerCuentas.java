/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo2p;

import ec.edu.espol.modelo.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author steve
 */
public class VerCuentas {
    public static ArrayList<CuentaRedSocial> listaRedes;
    @FXML
    private BorderPane borderPane;
    
    public void initialize(){
        TableView<CuentaRedSocial> tabla = new TableView<CuentaRedSocial>();
        tabla.setEditable(true);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn <CuentaRedSocial,String> columnaCuenta = new TableColumn<CuentaRedSocial,String>("Nombre de la Cuenta"); 
        columnaCuenta.setCellValueFactory(new PropertyValueFactory<CuentaRedSocial,String> ("cuenta"));
        columnaCuenta.setCellFactory(TextFieldTableCell.forTableColumn());
        columnaCuenta.setOnEditCommit(data -> {
        CuentaRedSocial c = data.getRowValue();
        c.setCuenta(data.getNewValue());
        });
        tabla.getColumns().add(columnaCuenta);
        TableColumn <CuentaRedSocial,RedSocial> columnaRed = new TableColumn<CuentaRedSocial,RedSocial>("Red Social"); 
        columnaRed.setCellValueFactory(new PropertyValueFactory<CuentaRedSocial,RedSocial> ("redSocial"));
        columnaRed.setCellFactory(ChoiceBoxTableCell.forTableColumn(FXCollections.observableArrayList(RedSocial.values())));
        tabla.getColumns().add(columnaRed);
        for(CuentaRedSocial cr: listaRedes){
            tabla.getItems().add(cr);
        }
        borderPane.setCenter(tabla);
    }
    
    public static void setListaRedes(ArrayList<CuentaRedSocial> lr){
        listaRedes = lr;
    }
    
    @FXML
    private void volver() throws IOException{
        ArrayList<CuentaRedSocial> lr = new ArrayList<CuentaRedSocial>();
        TableView t = (TableView) borderPane.getCenter();
        for(Object cr: t.getItems()){
            CuentaRedSocial c =(CuentaRedSocial) cr;
            lr.add(c);
        }
        EditarEmprendedor.setListaRedes(lr);
        App.setRoot("EditarEmprendedor");
    }
    
}
