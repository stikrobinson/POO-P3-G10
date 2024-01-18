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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author GENERATION 10
 */
public class Feria implements Serializable {
    private static int numCodigo;
    private int codigo;
    private String descripcion;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalTime horario;
    private String lugar;
    private static ArrayList<Feria> ferias = new ArrayList<>();
    private ArrayList<AuspicianteEnFeria> listaAuspiciantes;
    private ArrayList<Emprendedor> listaEmprendedores;
    private ArrayList<Stand> stands = new ArrayList<>();
    private ArrayList<Integer> codigosFerias;
    private int[] standsPorSector = new int[4];

    
    

    public Feria(String descripcion, String nombre, LocalDate fechaInicio, LocalDate fechaFin, LocalTime horario, String lugar, int[]stands) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horario = horario;
        this.lugar = lugar;
        //Inicializo ArrayList
        listaAuspiciantes=new ArrayList<>();
        listaEmprendedores=new ArrayList<>();
        standsPorSector = stands;
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de stands para la sección de Alimentación: ");
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
   public void generarStands(){ 
    char[] letras = {'A','B','C','D'};
   int contador =0;
    for(int i: standsPorSector){ 
        for(int n=0; n<i; n++){
        stands.add(new Stand(fechaInicio,letras[contador]));
    }           
    contador++;
    }
    }
    

    public int[] getStandsPorSector() {
        return standsPorSector;
        
        
    }

    
    public ArrayList<Integer> getCodigosFerias() {
        return codigosFerias;
    }
    public static void anadirFerias(Feria f){
        ferias.add(f);
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./src/main/resources/ec/edu/espol/archivos/ferias.ser"))) {
                  out.writeObject(ferias);
                  out.flush();
          }
          catch (Exception ex) {
              System.out.println(ex.getMessage());
          } 
    }
        public static void actualizarFerias(int i,Feria f){
        ferias.set(i,f);
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./src/main/resources/ec/edu/espol/archivos/ferias.ser"))) {
                  out.writeObject(ferias);
                  out.flush();
          }
          catch (Exception ex) {
              System.out.println(ex.getMessage());
          } 
    }
        public static void leerFerias(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("./src/main/resources/ec/edu/espol/archivos/ferias.ser"))){

            ferias = (ArrayList<Feria>) in.readObject();
            int size = ferias.size();
            try{
            Feria f = ferias.get(size-1);
            int codigo = f.getCodigo();
            numCodigo = codigo + numCodigo + 1;
            }catch(Exception e){
              numCodigo = 0;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } 

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
    
    public static ArrayList<Feria> getFerias(){
        return ferias;
    }
    
    
    
    

    @Override
   public String toString(){
       return "Nombre: " + nombre + "\nDescripción: " + descripcion + "\nLugar: " + lugar + "\nFecha Inicio: " + fechaInicio
               + "\nFecha Fin: " + fechaFin + "\nHorario: " + horario + "\nLista de Auspiciantes: " + listaAuspiciantes + "\nCantidad Stands por sección: \n";
               
   }
   
    public String mostrarInfo(){
        return "Codigo: " + codigo+ "\nNombre: " + nombre +"\nFecha Inicio: " + fechaInicio+  "\nLugar: " + lugar+ "\nCantidad de Auspiciantes: "+ listaAuspiciantes.size();   
    }
    
    
}
