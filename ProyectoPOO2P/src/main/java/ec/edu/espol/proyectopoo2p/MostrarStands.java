/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo2p;
import ec.edu.espol.modelo.*;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author steve
 */
public class MostrarStands {
    private static Feria feria;
    @FXML
    private VBox stands;
    @FXML
    private VBox info;
    
    
    
    public static void setFeria(Feria f){
     feria = f;
    }
    
     public void initialize() throws IOException{
       actualizar();
     }
    
     private void actualizar() throws IOException{
                  int contador =0;
         int contadorSeccion = 1;
             for(int i: feria.getStandsPorSector()){  
                 HBox hb = new HBox();
                 hb.setAlignment(Pos.CENTER);
                 hb.setSpacing(10);
                 Label lb = new Label("Sección " + contadorSeccion + ":");
                 hb.getChildren().add(lb);
                 for(int n=0; n<i; n++){
                 Stand s = feria.getStands().get(contador);
                 if(s.getOcupadoPor()==null){
                 FileInputStream in = new FileInputStream("./src/main/resources/ec/edu/espol/imagenes/standDesocupado.png");
                 Image imagen = new Image(in,50,50,false,false);
                 ImageView image = new ImageView(imagen);
                 image.addEventHandler(MouseEvent.MOUSE_CLICKED, e-> {
                 info.getChildren().clear();
                 ComboBox<Participante> cb = new ComboBox<>();
                 for(Emprendedor em: Emprendedor.getEmprendedores()){
                    cb.getItems().add(em); 
                 }
                 for(AuspicianteEnFeria a: feria.getListaAuspiciantes()){
                    if(a.getStand()){
                    cb.getItems().add(a.getAuspiciante()); 
                    }
                 }
                 Label infoStand = new Label(s.mostrarInfo());
                 Label reservar = new Label("El stand no está ocupado, puede reservarlo");
                 Button reserva = new Button("Reservar");
                 reserva.setOnAction( evento-> {
                 Participante p = (Participante) cb.getValue();
                 int cantStands = 0;
                 if(p instanceof Emprendedor){
                   for(Stand stand: feria.getStands()){
                       if(stand.getOcupadoPor()==p){
                           cantStands++;
                       }
                   }
                 }
                 if(cantStands >= 2){
                     showMessage(AlertType.ERROR,"Falla al reservar stand", "", "No se puede reservar stand, porque un emprendedor puede reservar hasta dos stands.");
                 }
                 else{
                     s.setOcupadoPor(p);
                     showMessage(AlertType.INFORMATION,"Se reservó stand", "", "El stand ha sido reservado para el emprendedor o el auspiciante.");
                     Thread actualizarPantalla = new Thread(new Runnable(){
                         public void run(){
                            Platform.runLater(()->{
                                try{
                                    stands.getChildren().clear();
                                    actualizar();
                                }catch(IOException ex){
                                    System.out.println(ex.getMessage());
                                }});
                         }
                     });
                     actualizarPantalla.start();
                 }
                 });
                 info.getChildren().addAll(infoStand,reservar,cb,reserva);
                 });
                 hb.getChildren().add(image);
                 contador++;
                 }else{
                 FileInputStream in = new FileInputStream("./src/main/resources/ec/edu/espol/imagenes/standOcupado.png");
                 Image imagen = new Image(in);
                 ImageView image = new ImageView(imagen);
                 image.setFitHeight(50);
                 image.setFitWidth(50);
                 image.addEventHandler(MouseEvent.MOUSE_CLICKED, e-> {
                 info.getChildren().clear();
                 Label reservado = new Label("Este stand ha sido reservado.");
                 Label infoCompleta = new Label(s.mostrarInfoCompleta());
                 info.getChildren().addAll(reservado,infoCompleta);
                 });
                 hb.getChildren().add(image);
                 contador++;
             }
             }
                 stands.getChildren().add(hb);
                 contadorSeccion++;
         }    
     }
     
         public void showMessage(Alert.AlertType tipo, String titulo, String encabezado, String mensaje) {
    Alert alerta = new Alert(tipo);
    alerta.setHeaderText(encabezado);
    alerta.setTitle(titulo);
    alerta.setContentText(mensaje);
    alerta.showAndWait();                         
    }
    
    
}

