/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;

import java.time.LocalDate;

/**
 *
 * @author GENERATION 10
 */
public class Stand {
    private int codigoStand;
    private SectorCubierto seccion;
    private LocalDate fechaAsignacion;
    private Participante ocupadoPor;
    private char letra;
   

    public Stand(int codigoStand, SectorCubierto seccion, LocalDate fechaAsignacion, Participante ocupadoPor, char letra) {
        this.codigoStand = codigoStand;
        this.seccion = seccion;
        this.fechaAsignacion = fechaAsignacion;
        this.ocupadoPor = ocupadoPor;
        this.letra = letra;
        
    }
    
    
    
    
    public int getCodigoStand() {
        return codigoStand;
    }

    public void setCodigoStand (int codigoStand) {
        this.codigoStand = codigoStand;
    }

    public SectorCubierto getSeccion() {
        return seccion;
    }

    public void setSeccion(SectorCubierto seccion) {
        this.seccion = seccion;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Participante getOcupadoPor() {
        return ocupadoPor;
    }

    public void setOcupadoPor(Participante ocupadoPor) {
        this.ocupadoPor = ocupadoPor;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }
    
    
    
    public void asignarLetra(){
        if(seccion == SectorCubierto.ALIMENTACION){
            letra = 'A';
        }else if(seccion == SectorCubierto.EDUCACION){
            letra = 'B';
        }else if(seccion == SectorCubierto.SALUD){
            letra = 'C';
        }else if(seccion == SectorCubierto.VESTIMENTA){
            letra = 'D';
        }
    }
    
    public String toString(){
        return "" + letra;
    }
    
    
    
}