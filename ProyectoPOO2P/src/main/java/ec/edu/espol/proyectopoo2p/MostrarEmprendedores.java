/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo2p;

import ec.edu.espol.modelo.*;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author steve
 */
public class MostrarEmprendedores {
    public static boolean mostrarAuspiciantes;
    public static Feria feria;
    @FXML
    private Label titulo;
    @FXML
    private VBox info;
    
    public void initialize() throws IOException{
        int contador =1;
        if(mostrarAuspiciantes){
            for(AuspicianteEnFeria a: feria.getListaAuspiciantes()){
            HBox hb = new HBox();
            HBox indicadores = new HBox();
            indicadores.setSpacing(20);
            indicadores.setAlignment(Pos.CENTER_LEFT);
            HBox.setMargin(indicadores, new Insets(5,0,0,10));
            hb.setSpacing(20);
            hb.setAlignment(Pos.CENTER_LEFT);
            Label cont = new Label(contador+"");
            FileInputStream in = new FileInputStream("./src/main/resources/ec/edu/espol/imagenes/auspiciante.png");
            Image imagen = new Image(in);
            ImageView image = new ImageView(imagen);
            image.setFitHeight(90);
            image.setFitWidth(90);
            String informacion = a.mostrarInfo(feria);
            Label lb = new Label(informacion);
            contador++;
            indicadores.getChildren().addAll(cont,image);
            hb.getChildren().addAll(indicadores,lb);
            info.getChildren().addAll(hb);
            }
        }else{
            for(Emprendedor e: feria.getListaEmprendedores()){
            HBox hb = new HBox();
            HBox indicadores = new HBox();
            indicadores.setSpacing(20);
            HBox.setMargin(indicadores, new Insets(5,0,0,10));
            indicadores.setAlignment(Pos.CENTER_LEFT);
            hb.setSpacing(20);
            hb.setAlignment(Pos.CENTER_LEFT);
            Label cont = new Label(contador+"");
            FileInputStream in = new FileInputStream("./src/main/resources/ec/edu/espol/imagenes/emprendedor.png");
            Image imagen = new Image(in);
            ImageView image = new ImageView(imagen);
            image.setFitHeight(90);
            image.setFitWidth(90);
            String informacion = e.mostrarInfoCompleta(feria);
            Label lb = new Label(informacion);
            contador++;
            indicadores.getChildren().addAll(cont,image);
            hb.getChildren().addAll(indicadores,lb);
            info.getChildren().addAll(hb);
        }
        }
    }
    
    public static void setFeria(Feria f){
        feria = f;
    }
    public static void setMostrarAuspiciantes(boolean b){
        mostrarAuspiciantes = b;
    }
    
    @FXML
    private void volver() throws IOException{
        App.setRoot("AdministrarFerias");
    }
}
