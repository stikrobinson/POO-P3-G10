package ec.edu.espol.proyectopoo2p;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ec.edu.espol.modelo.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MenuPrincipal"), 640, 480);
        Feria.leerFerias();
        Auspiciante.leerAuspiciantes();
        Emprendedor.leerEmprendedores();
        
        LocalDate fechaInicioEjemplo = LocalDate.of(2023, 1, 1);
        LocalDate fechaFinEjemplo = LocalDate.of(2023, 12, 31);
        LocalTime horaEjemplo = LocalTime.of(12, 30, 0);
        int[] a ={5,5,5,5}; 
        Feria feriaPrueba = new Feria("Esta es una feria de prueba pasada", "Feria de Prueba Pasada", fechaInicioEjemplo, fechaFinEjemplo, horaEjemplo, "Guayaquil",a);
        feriaPrueba.generarStands();
        
        
        LocalDate fechaInicioEjemplo1 = LocalDate.of(2024, 1, 30);
        LocalDate fechaFinEjemplo1 = LocalDate.of(2024, 3, 31);
        LocalTime horaEjemplo1 = LocalTime.of(10, 0, 0);
        int[] b ={4,4,4,4}; 
        Feria feriaPrueba1 = new Feria("Esta es otra feria de prueba activa", "Feria de Prueba Activa", fechaInicioEjemplo1, fechaFinEjemplo1, horaEjemplo1, "Quito",b);
        feriaPrueba1.generarStands();
        
        
        Auspiciante auspicianteP = new Auspiciante("0914389777", "0939770499", "auspiciante@gmail.com", "Calle A y B Casa 1", "google.com", "Juan", "Marcos", SectorCubierto.ALIMENTACION);
        Auspiciante auspicianteA = new Auspiciante("0930923958", "0984555755", "auspiciante@hotmail.com", "Calle C y D Casa 2", "facebook.com", "Carla", "Norma", SectorCubierto.EDUCACION);
        AuspicianteEnFeria af = new AuspicianteEnFeria(auspicianteP);
        AuspicianteEnFeria afA = new AuspicianteEnFeria(auspicianteA, "Descripción", true);
        Auspiciante.getAuspiciantes().add(auspicianteP);
        Auspiciante.getAuspiciantes().add(auspicianteA);
        
        Emprendedor emprendedor1 = new Emprendedor("123456", "555-1234", "correo@ejemplo.com", "Calle Principal 123", "www.miemprendimiento.com", "Juan Pérez", "Responsable1", "Descripción1");
        Emprendedor emprendedor2 = new Emprendedor("789012", "555-5678", "otrocorreo@ejemplo.com", "Avenida Secundaria 456", "www.otroemprendimiento.com", "Ana López", "Responsable2", "Descripción2");
        Emprendedor emprendedor3 = new Emprendedor("345678", "555-4321", "correo3@ejemplo.com", "Calle Secundaria 789", "www.terceremprendimiento.com", "Roberto Gómez", "Responsable3", "Descripción3");
        Emprendedor emprendedor4 = new Emprendedor("901234", "555-8765", "correo4@ejemplo.com", "Avenida Principal 012", "www.cuartoemprendimiento.com", "Laura Martínez", "Responsable4", "Descripción4");
        
        
        feriaPrueba.getListaAuspiciantes().add(af);
        feriaPrueba.getListaEmprendedores().add(emprendedor1);
        feriaPrueba.getListaEmprendedores().add(emprendedor2);
        feriaPrueba.getListaEmprendedores().add(emprendedor3);
        feriaPrueba.getListaEmprendedores().add(emprendedor4);       
        
        feriaPrueba1.getListaAuspiciantes().add(afA);
        feriaPrueba1.getListaEmprendedores().add(emprendedor1);
        feriaPrueba1.getListaEmprendedores().add(emprendedor2);
        feriaPrueba1.getListaEmprendedores().add(emprendedor3);
        feriaPrueba1.getListaEmprendedores().add(emprendedor4);   
        
        feriaPrueba.getStands().get(0).setOcupadoPor(emprendedor1);
        feriaPrueba.getStands().get(5).setOcupadoPor(emprendedor2);
        feriaPrueba.getStands().get(10).setOcupadoPor(emprendedor3);
        feriaPrueba.getStands().get(15).setOcupadoPor(emprendedor4);
        
        feriaPrueba1.getStands().get(0).setOcupadoPor(emprendedor1);
        feriaPrueba1.getStands().get(4).setOcupadoPor(emprendedor2);
        feriaPrueba1.getStands().get(8).setOcupadoPor(emprendedor3);
        feriaPrueba1.getStands().get(12).setOcupadoPor(emprendedor4);
        
        Emprendedor.getEmprendedores().add(emprendedor1);
        Emprendedor.getEmprendedores().add(emprendedor2);
        Emprendedor.getEmprendedores().add(emprendedor3);
        Emprendedor.getEmprendedores().add(emprendedor4);
        Feria.getFerias().add(feriaPrueba);
        Feria.getFerias().add(feriaPrueba1);
        
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}