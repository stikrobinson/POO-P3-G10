/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo2p;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ec.edu.espol.modelo.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author steve
 */
public class EditarFeria {
    public static Feria feria;
    public static boolean nuevaFeria;
    @FXML
    private Label titulo;
    @FXML
    private TextField nombre;
    @FXML
    private TextField descripcion;
    @FXML
    private TextField lugar;
    @FXML
    private DatePicker fechaInicio;
    @FXML
    private DatePicker fechaFin;
    @FXML
    private TextField horario;
    @FXML
    private TextField cantStand1;
    @FXML
    private TextField cantStand2;
    @FXML
    private TextField cantStand3;
    @FXML
    private TextField cantStand4;
    
    public void initialize(){
        if(nuevaFeria){
            titulo.setText("Crear Feria");
        }else{
            titulo.setText("Editar Feria");
            nombre.setText(feria.getNombre());
            descripcion.setText(feria.getDescripcion());
            lugar.setText(feria.getLugar());
            fechaInicio.setValue(feria.getFechaInicio());
            fechaFin.setValue(feria.getFechaFin());
            horario.setText(feria.getHorario().toString());
            int[] stands = feria.getStandsPorSector();
            cantStand1.setText(String.valueOf(stands[0]));
            cantStand2.setText(String.valueOf(stands[1]));
            cantStand3.setText(String.valueOf(stands[2]));
            cantStand4.setText(String.valueOf(stands[3]));
        }
    }
    
    @FXML
    private void guardar() throws IOException{
        if(nuevaFeria){
            try{
            String[] division = horario.getText().split(":");
            LocalTime l = LocalTime.of(Integer.valueOf(division[0]),Integer.valueOf(division[1]));
            int[] stand = {Integer.valueOf(cantStand1.getText()),Integer.valueOf(cantStand2.getText()),Integer.valueOf(cantStand3.getText()),Integer.valueOf(cantStand4.getText())};
            Feria f = new Feria(descripcion.getText(),nombre.getText(),fechaInicio.getValue(),fechaFin.getValue(),l,lugar.getText(),stand);
            f.generarStands();
            Feria.anadirFerias(f);
            App.setRoot("AdministrarFerias");
            }catch(Exception e){
                showMessage(AlertType.ERROR, "Error al ingresar datos", "", "Ingrese los datos correctamente");
            }
        }else{
            try{
            String[] division = horario.getText().split(":");
            LocalTime l = LocalTime.of(Integer.valueOf(division[0]),Integer.valueOf(division[1]));
            int[] stand = {Integer.valueOf(cantStand1.getText()),Integer.valueOf(cantStand2.getText()),Integer.valueOf(cantStand3.getText()),Integer.valueOf(cantStand4.getText())};
            feria.setNombre(nombre.getText());
            feria.setDescripcion(descripcion.getText());
            feria.setLugar(lugar.getText());
            feria.setFechaInicio(fechaInicio.getValue());
            feria.setFechaFin(fechaFin.getValue());
            feria.setHorario(l);
            if((Arrays.equals(feria.getStandsPorSector(),stand))==false){
                    Alert alerta = new Alert(AlertType.CONFIRMATION);
                    alerta.setTitle("Confirmación");
                    alerta.setContentText("Si cambias la distribución de stands, todos los stands serán desocupados ¿Estás seguro?");
                    Optional<ButtonType> result = alerta.showAndWait();
                    if (result.get() == ButtonType.OK){
                                     feria.setStandsPorSector(stand);
                                     feria.generarStands();
                                     feria.getListaEmprendedores().clear();
                                     Feria.actualizarFerias(feria.getCodigo(),feria);
                                     App.setRoot("AdministrarFerias");
                    }
            }else{
            Feria.actualizarFerias(feria.getCodigo(),feria);
            App.setRoot("AdministrarFerias");
            }
            }catch(Exception e){
                showMessage(AlertType.ERROR, "Error al ingresar datos", "", "Ingrese los datos correctamente");
        }
    }
    }    
    
    @FXML
    private void cancelar() throws IOException{
        App.setRoot("AdministrarFerias");
    }
    
    public void showMessage(Alert.AlertType tipo, String titulo, String encabezado, String mensaje) {
    Alert alerta = new Alert(tipo);
    alerta.setHeaderText(encabezado);
    alerta.setTitle(titulo);
    alerta.setContentText(mensaje);
    alerta.showAndWait();                         
    }
    

    public static void setNuevaFeria(boolean b){
        nuevaFeria = b;
    }
     public static void setFeria(Feria f){
        feria = f;
    }
}
