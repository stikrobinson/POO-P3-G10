/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo2p;

import ec.edu.espol.modelo.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 *
 * @author steve
 */
public class MostrarDetalles {
    public static Feria feria;
    @FXML
    private Label nombre;
    @FXML
    private Label descripcion;
    @FXML
    private Label lugar;
    @FXML
    private Label fechaInicio;
    @FXML
    private Label fechaFin;
    @FXML
    private Label horario;
    @FXML
    private Text listaAuspiciantes;
    @FXML
    private Text listaEmprendedores;
    @FXML
    private Label sec1;    
    @FXML
    private Label sec2;
    @FXML
    private Label sec3;
    @FXML
    private Label sec4;
    
    public void initialize(){
        nombre.setText(feria.getNombre());
         descripcion.setText(feria.getDescripcion());
          lugar.setText(feria.getLugar());
           fechaInicio.setText(feria.getFechaInicio().toString());
           fechaFin.setText(feria.getFechaFin().toString());
           horario.setText(feria.getHorario().toString());
           listaAuspiciantes.setText(feria.getListaAuspiciantes().toString());
           listaEmprendedores.setText(feria.getListaEmprendedores().toString());
           int [] stands = feria.getStandsPorSector();
           sec1.setText(stands[0]+"");
           sec2.setText(stands[1]+"");
           sec3.setText(stands[2]+"");
           sec4.setText(stands[3]+"");
    }
    
    public static void setFeria(Feria f){
        feria = f;
    }
    
    @FXML
    private void volver() throws IOException{
        App.setRoot("AdministrarFerias");
    }
    
}
