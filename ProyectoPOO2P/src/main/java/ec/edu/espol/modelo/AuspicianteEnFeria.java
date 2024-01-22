/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author GENERATION 10
 */
public class AuspicianteEnFeria implements Serializable {
    private Auspiciante auspiciante;
    private boolean stand;    
    private String descripcion;

    
    public AuspicianteEnFeria(Auspiciante auspiciante){
        this.auspiciante = auspiciante;
    }
    
    public AuspicianteEnFeria(Auspiciante a, String des, boolean s) {
        auspiciante = a;
        descripcion = des;
        stand = s;
    }
    
    


    public Auspiciante getAuspiciante() {
        return auspiciante;
    }

    public void setAuspiciante(Auspiciante auspiciante) {
        this.auspiciante = auspiciante;
    }
    
    public boolean getStand(){
        return stand;
    }
    
    public String toString(){
        return auspiciante.toString();
    }
    
    public String mostrarInfo(Feria f){
        String tieneStand;
        String standAsignado = "No aplica";
        if(stand){
            tieneStand = "Sí";
            standAsignado = "";
            for(Stand s: f.getStands()){
            if(s.getOcupadoPor()!=null){
                if(s.getOcupadoPor().equals(this)){
                    if(standAsignado.equals("")){
                        standAsignado = standAsignado + s.getCodigoStand();
                    }else{
                        standAsignado = standAsignado + " - "  + s.getCodigoStand();
                     }
            }
            }
            }
            if(standAsignado.equals("")){
                standAsignado = "No se le ha asignado stand";
            }
        }else{
            tieneStand = "No";
        }
        return auspiciante.toString() + "\nDescripción del auspicio: " + descripcion + "\nTiene stand asignado: " + tieneStand + "\nStand asignado: " + standAsignado;
        
    }
    
}
