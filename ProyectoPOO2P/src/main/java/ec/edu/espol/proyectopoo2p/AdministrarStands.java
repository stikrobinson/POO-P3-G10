package ec.edu.espol.proyectopoo2p;

import java.io.IOException;
import javafx.fxml.FXML;
import ec.edu.espol.modelo.*;
import java.io.FileInputStream;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AdministrarStands {

    @FXML
    private VBox ferias;
    
    public void initialize() throws IOException{
    for(Feria f: Feria.getFerias()){
        HBox hb = new HBox();
        hb.setSpacing(20);
        hb.setAlignment(Pos.CENTER_LEFT);
        VBox.setMargin(hb, new Insets(5,0,0,80));
        FileInputStream in = new FileInputStream("./src/main/resources/ec/edu/espol/imagenes/Imagenferia.png");
        Image imagen = new Image(in);
        ImageView image = new ImageView(imagen);
        image.setFitHeight(100);
        image.setFitWidth(100);
        Label lb = new Label(f.mostrarInfo());
        Button bt = new Button("Administrar stands");
        bt.setOnAction(e->{ MostrarStands.setFeria(f);
            try{
            MostrarStands.setVolverAFerias(false);
            App.setRoot("MostrarStands");
            }catch(Exception ex){
             System.out.println(ex.getMessage());
             }        
            });
        hb.getChildren().addAll(image,lb,bt);
        ferias.getChildren().add(hb);
    }
    }
    
    @FXML
    private void volver() throws IOException{
      App.setRoot("MenuPrincipal");  
    }
}