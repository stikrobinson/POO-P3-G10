/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author GENERATION 10
 */
public class Feria {
    private static int numCodigo=0;
    private int codigo;
    private String descripcion;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalTime horario;
    private String lugar;
    private ArrayList<AuspicianteEnFeria> listaAuspiciantes;
    private ArrayList<Emprendedor> listaEmprendedores;
    private ArrayList<Stand> stands;
    private ArrayList<Integer> codigosFerias;
    
    private ArrayList<Integer> standsPorSector;

    
    

    public Feria(String descripcion, String nombre, LocalDate fechaInicio, LocalDate fechaFin, LocalTime horario, String lugar) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horario = horario;
        this.lugar = lugar;
        //Inicializo ArrayList
        listaAuspiciantes=new ArrayList<>();
        listaEmprendedores=new ArrayList<>();
        stands=new ArrayList<>();
        codigosFerias=new ArrayList<>();
        standsPorSector=new ArrayList<>();
        /*int codigoAleatorio;
        do{
            codigoAleatorio = generarCodigoAleatorio();
        } while(codigosFerias.contains(codigoAleatorio));
        
        codigosFerias.add(codigoAleatorio);
        codigo = codigoAleatorio; */
        codigo=numCodigo;
        numCodigo++; //El codigo debe incrementar en uno cada vez que se itera
    }

     private static int generarCodigoAleatorio() {
        return 10000 + new Random().nextInt(90000);
    }
    
    
    public String getDescripcion() {
        return descripcion;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public String getLugar() {
        return lugar;
    }

    public ArrayList<AuspicianteEnFeria> getListaAuspiciantes() {
        return listaAuspiciantes;
    }

    public ArrayList<Emprendedor> getListaEmprendedores() {
        return listaEmprendedores;
    }

    public ArrayList<Stand> getStands() {
        return stands;
    }

    

    public ArrayList<Integer> getStandsPorSector() {
        return standsPorSector;
        
        
    }
    
    public ArrayList<Integer> getCodigosFerias() {
        return codigosFerias;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setListaAuspiciantes(ArrayList<AuspicianteEnFeria> listaAuspiciantes) {
        this.listaAuspiciantes = listaAuspiciantes;
    }

    public void setListaEmprendedores(ArrayList<Emprendedor> listaEmprendedores) {
        this.listaEmprendedores = listaEmprendedores;
    }

    public void setStands(ArrayList<Stand> stands) {
        this.stands = stands;
    }

    public void setCodigosFerias(ArrayList<Integer> codigosFerias) {
        this.codigosFerias = codigosFerias;
    }

    public void setStandsPorSector(ArrayList<Integer> standsPorSector) {
        this.standsPorSector = standsPorSector;
    }
    
    
    
    public String calcularStands(){
        int standsAlimentacion = 0;
        int standsEducacion = 0;
        int standsSalud = 0;
        int standsVivienda = 0;
        
        for(Stand s: stands){
            if(s.getSeccion()==SectorCubierto.ALIMENTACION){
                standsAlimentacion++;
            }
            if(s.getSeccion()==SectorCubierto.EDUCACION){
                standsEducacion++;
            }
            if(s.getSeccion()==SectorCubierto.SALUD){
                standsSalud++;
            }
            if(s.getSeccion()==SectorCubierto.VIVIENDA){
                standsVivienda++;
            }
            
      
        }
        return "Stands de Alimentación: "+ standsAlimentacion + "\nStands de Educación: " + standsEducacion +
                "\nStands de Salud: "+ standsSalud + "\nStands de Vivienda: "+ standsVivienda;
    }

    @Override
   public String toString(){
       return "Nombre: " + nombre + "\nDescripción: " + descripcion + "\nLugar: " + lugar + "\nFecha Inicio: " + fechaInicio
               + "\nFecha Fin: " + fechaFin + "\nHorario: " + horario + "\nLista de Auspiciantes: " + listaAuspiciantes + "\nCantidad Stands por sección: \n"
               + calcularStands();
   }
    public String mostrarInfo(){
        return "Codigo:" + codigo+ "\nNombre: " + nombre +"\nFecha Inicio: " + fechaInicio+  "\nLugar: " + lugar+ "\nCantidad de Auspiciantes: "+ listaAuspiciantes.size();   
    }
    
    
}
