package ec.edu.espol.proyectopoo2p;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class MenuPrincipal {

    @FXML
    private void administrarFerias() throws IOException{
    App.setRoot("AdministrarFerias");      
    }
    
    @FXML
    private void administrarEmprendedores()throws IOException{
    App.setRoot("AdministrarEmprendedores");
    }
    
    @FXML
    private void administrarStands() throws IOException{
    App.setRoot("AdministrarStands");      
    }
    
    @FXML
    private void administrarAuspiciantes(){
    
    }
    
    @FXML
    private void salir(){
       Platform.exit();
    }
}
