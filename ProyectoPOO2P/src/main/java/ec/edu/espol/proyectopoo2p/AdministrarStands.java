package ec.edu.espol.proyectopoo2p;

import java.io.IOException;
import javafx.fxml.FXML;

public class AdministrarStands {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}