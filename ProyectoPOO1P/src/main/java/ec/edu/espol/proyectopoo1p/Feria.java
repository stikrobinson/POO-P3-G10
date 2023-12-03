/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
    private ArrayList<Stand> stands = new ArrayList<>();
    private ArrayList<Integer> codigosFerias;
    private int[] standsPorSector = new int[4];

    
    

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
        
        codigosFerias=new ArrayList<>();
        
        
        Scanner sc = new Scanner(System.in);
        /*System.out.println("Ingrese la cantidad de stands para la sección de Alimentación: ");
        int seccionA = sc.nextInt();
        standsPorSector[0] = seccionA;
        System.out.println("Ingrese la cantidad de stands para la sección de Educación: ");
        int seccionB = sc.nextInt();
        standsPorSector[1] = seccionB;
        System.out.println("Ingrese la cantidad de stands para la sección de Educación");
        int seccionC = sc.nextInt();
        standsPorSector[2] = seccionC;
        System.out.println("Ingrese la cantidad de stands para la sección de Vestimenta");
        int seccionD = sc.nextInt();
        standsPorSector[3] = seccionD;        
        
        */
                
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

    

    public int[] getStandsPorSector() {
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

    public void setStandsPorSector(int[] standsPorSector) {
        this.standsPorSector = standsPorSector;
    }
    
    
    
    

    @Override
   public String toString(){
       return "Nombre: " + nombre + "\nDescripción: " + descripcion + "\nLugar: " + lugar + "\nFecha Inicio: " + fechaInicio
               + "\nFecha Fin: " + fechaFin + "\nHorario: " + horario + "\nLista de Auspiciantes: " + listaAuspiciantes + "\nCantidad Stands por sección: \n";
               
   }
    public String mostrarInfo(){
        return "Codigo:" + codigo+ "\nNombre: " + nombre +"\nFecha Inicio: " + fechaInicio+  "\nLugar: " + lugar+ "\nCantidad de Auspiciantes: "+ listaAuspiciantes.size();   
    }
    
    
}
