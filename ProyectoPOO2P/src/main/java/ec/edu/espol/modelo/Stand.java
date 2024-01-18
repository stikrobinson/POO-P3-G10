/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author GENERATION 10
 */
public class Stand implements Serializable{
    private int codigoStand;
    private static int codigo = 0;
    private SectorCubierto seccion;
    private LocalDate fechaAsignacion;
    private Participante ocupadoPor;
    private char letra;
   

    public Stand(LocalDate fechaAsignacion, char letra) {
        codigoStand = codigo;
        this.fechaAsignacion = fechaAsignacion;
        this.letra = letra;
        codigo++;
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
    
    public String mostrarInfo(){
        int sec = 0;
        switch (letra) {
            case 'A':
                sec = 1;
                break;
            case 'B':
                sec =2;
                break;
            case 'C':
                sec =3;
                break;
            case 'D':
                sec =4;
                break;
            default:
                break;
        }
        return "Codigo: " + codigoStand + "\n" + "Sección: " + sec + "\n" + "Fecha de asignación: " + fechaAsignacion;
    }
    
    
    public String mostrarInfoCompleta(){
        int sec = 0;
        switch (letra) {
            case 'A':
                sec = 1;
                break;
            case 'B':
                sec =2;
                break;
            case 'C':
                sec =3;
                break;
            case 'D':
                sec =4;
                break;
            default:
                break;
        }
        return "Codigo: " + codigoStand + "\n" + "Sección: " + sec + "\n" + "Fecha de asignación: " + fechaAsignacion + "\n" + "Ocupado por: " + ocupadoPor.getNombre_responsable()+ "\n" + "Teléfono: " + ocupadoPor.getTelefono() + "\n" + "Email : " + ocupadoPor.getEmail();
    }
    
}