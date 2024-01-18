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
public class Participante implements Serializable{
    
    private int codigo;
    private String cedula;
    private String telefono;
    private String email;
    private String direccion;
    private String sitio_web;
    private String nombre_responsable;
    private ArrayList<CuentaRedSocial> listaRedesSociales;
  

  
public String getCedula() {
    return cedula;
}

public void setCedula(String cedula) {
    this.cedula = cedula;
}

public String getTelefono() {
    return telefono;
}

public void setTelefono(String telefono) {
    this.telefono = telefono;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getDireccion() {
    return direccion;
}

public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public String getSitio_web() {
    return sitio_web;
}

public void setSitio_web(String sitio_web) {
    this.sitio_web = sitio_web;
}

public String getNombre_responsable() {
    return nombre_responsable;
}

public void setNombre_responsable(String nombre_responsable) {
    this.nombre_responsable = nombre_responsable;
}

public ArrayList<CuentaRedSocial> getListaRedesSociales() {
    return listaRedesSociales;
}

public void setListaRedesSociales(ArrayList<CuentaRedSocial> listaRedesSociales) {
    this.listaRedesSociales = listaRedesSociales;
}  
    public Participante(String c, String t, String e, String d, String s, String n){
      cedula = c;
      telefono = t;
      email = e;
      direccion = d;
      sitio_web = s;
      nombre_responsable = n;
      listaRedesSociales = new ArrayList<>();
      
      codigo++;
  }
      
  @Override
  public String toString(){
    String redes = "";
    int contador = 1;
    for(CuentaRedSocial cuenta: listaRedesSociales){
      redes = redes + cuenta;
      if(contador != listaRedesSociales.size()){
        redes = redes + " - ";
      }
      contador++;
    }
    return "Cedula: " + cedula + "\nTelefono: " + telefono + "\nEmail: " + email + "\nDireccion: " + direccion + "\nSitio web: " + sitio_web + "\nResponsable: " + nombre_responsable + "\nRedes Sociales:\n" + redes;
  }


    public int getCodigo() {
        return codigo;
    }
}

