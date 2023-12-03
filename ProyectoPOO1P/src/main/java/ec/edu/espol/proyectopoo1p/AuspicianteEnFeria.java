/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;

import java.util.ArrayList;

/**
 *
 * @author GENERATION 10
 */
public class AuspicianteEnFeria {
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
    
    
    
    
}
