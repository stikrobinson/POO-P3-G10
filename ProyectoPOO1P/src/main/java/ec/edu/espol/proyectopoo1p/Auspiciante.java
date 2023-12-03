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
public class Auspiciante extends Participante {
    private SectorCubierto sector;
    
    private ArrayList<Stand> standsAsignados;

    public Auspiciante(String c, String t, String e, String d, String s, String n){
      super(c,t,e,d,s,n);
    }

    public SectorCubierto getSector() {
        return sector;
    }

    public void setSector(SectorCubierto sector) {
        this.sector = sector;
    }

    public ArrayList<Stand> getStandsAsignados() {
        return standsAsignados;
    }

    public void setStandsAsignados(ArrayList<Stand> standsAsignados) {
        this.standsAsignados = standsAsignados;
    }
    
    
    
}
