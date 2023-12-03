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
    private static ArrayList<Emprendedor> emprendedores = new ArrayList<>();
    private SectorCubierto seccion;
    private ArrayList<Stand> standsAsignados;

    public Emprendedor(String c, String t, String e, String d, String s, String n, String responsable, String descripcion){
      super(c,t,e,d,s,responsable);
      nombreEmprendimiento = n;
      this.descripcion = descripcion;
    }
  
    public SectorCubierto getSeccion() {
        return seccion;
    }

    public void setSeccion(SectorCubierto seccion) {
        this.seccion = seccion;
    }

    public ArrayList<Stand> getStandsAsignados() {
        return standsAsignados;
    }

    public void setStandsAsignados(ArrayList<Stand> standsAsignados) {
        this.standsAsignados = standsAsignados;
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

    public static ArrayList<Emprendedor> getEmprendedores() {
        return emprendedores;
    }

    public static void setEmprendedores(ArrayList<Emprendedor> e) {
        emprendedores = e;
    }
    @Override
    public ArrayList<CuentaRedSocial> getListaRedesSociales(){
      return super.getListaRedesSociales();
    }
    public String mostrarInfo(){
      return "\nNombre del emprendimiento: " + nombreEmprendimiento + "\n" + super.toString() + "\nDescripcion: " + descripcion; 
    }

    public String mostrarInfoBasica(){
      return "Cédula: " + super.getCedula() + "\nNombre: " + nombreEmprendimiento + "\nTeléfono: " + super.getTelefono() + "\nEmail: " + super.getEmail();
    }
  
    @Override
    public String toString(){

        return "Nombre del emprendimiento: " + nombreEmprendimiento + "\nDescripción: " + descripcion + "\nSección" + seccion
                + "\nStand asignado: "+ standsAsignados;

    }
}


