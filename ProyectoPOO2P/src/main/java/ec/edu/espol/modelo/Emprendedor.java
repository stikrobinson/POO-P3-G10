/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author GENERATION 10
 */
public class Emprendedor extends Participante implements Serializable {
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
    public static void anadirEmprendedores(Emprendedor e){
        emprendedores.add(e);
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./src/main/resources/ec/edu/espol/archivos/emprendedores.ser"))) {
                  out.writeObject(emprendedores);
                  out.flush();
          }
          catch (Exception ex) {
              System.out.println(ex.getMessage());
          } 
    }
        public static void actualizarEmprendedores(int i,Emprendedor e){
        emprendedores.set(i,e);
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./src/main/resources/ec/edu/espol/archivos/emprendedores.ser"))) {
                  out.writeObject(emprendedores);
                  out.flush();
          }
          catch (Exception ex) {
              System.out.println(ex.getMessage());
          } 
    }
        public static void leerEmprendedores(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("./src/main/resources/ec/edu/espol/archivos/emprendedores.ser"))){

            emprendedores = (ArrayList<Emprendedor>) in.readObject();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } 

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


