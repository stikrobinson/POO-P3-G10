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
public class Emprendedor extends Participante {
    private String nombreEmprendimiento;
    private String descripcion;
    private ArrayList<Emprendedor> emprendedores;
    private SectorCubierto seccion;
    private Stand standAsignado;

    public SectorCubierto getSeccion() {
        return seccion;
    }

    public void setSeccion(SectorCubierto seccion) {
        this.seccion = seccion;
    }

    public Stand getStandAsignado() {
        return standAsignado;
    }

    public void setStandAsignado(Stand standAsignado) {
        this.standAsignado = standAsignado;
    }
    
    

    public String getNombreEmprendimiento() {
        return nombreEmprendimiento;
    }

    public void setNombreEmprendimiento(String nombreEmprendimiento) {
        this.nombreEmprendimiento = nombreEmprendimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Emprendedor> getEmprendedores() {
        return emprendedores;
    }

    public void setEmprendedores(ArrayList<Emprendedor> emprendedores) {
        this.emprendedores = emprendedores;
    }
    
    @Override
    public String toString(){
        return "Nombre del emprendimiento: " + nombreEmprendimiento + "\nDescripción: " + descripcion + "\nSección" + seccion
                + "\nStand asignado: "+ standAsignado;
            
    }
}

