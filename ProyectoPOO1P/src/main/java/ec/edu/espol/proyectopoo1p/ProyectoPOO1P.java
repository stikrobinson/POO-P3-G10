/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.proyectopoo1p;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author GENERATION 10
 */
public class ProyectoPOO1P {

    public static void main(String[] args) {
        
        ArrayList <Feria> ferias = new ArrayList<>();
        ArrayList <Emprendedor> emprendedores = new ArrayList<>();
        int num;
        do{
        
        System.out.println("Bienvenido a la aplicación de manejo de ferias");
        System.out.println("\nEscoja una opción:");
        System.out.println("1. Administración de Ferias");
        System.out.println("2. Administración de Emprendedores");
        System.out.println("3. Administración de Auspiciantes");
        System.out.println("4. Administración de Stands");
        System.out.println("5. Salir");
        
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        
        
        switch(num){
            
            case 1:
                
                do{
                System.out.println("\nListado de ferias:");
                for (Feria f:ferias){
                    System.out.println(f.mostrarInfo());
                }
                System.out.println("1. Ver información de feria");
                System.out.println("2. Registrar feria");
                System.out.println("3. Editar feria");
                System.out.println("4. Consultar emprendedores feria");
                System.out.println("5. Regresar");
                
                num = sc.nextInt();
                sc.nextLine();
                switch (num) {
                    case 1: 
                        System.out.println("\nIngrese el código de la feria: ");
                        num = sc.nextInt();
                        for(Feria f : ferias){
                            if(num == f.getCodigo()){
                                System.out.println(f);
                            }
                        }break;
                    
                    case 2: 
                        System.out.println("Ingrese los datos de la feria");
                        System.out.println("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Descripción: ");
                        String descripcion = sc.nextLine();
                        System.out.println("Lugar: ");
                        String lugar = sc.nextLine();
                        System.out.println("Fecha de inicio (YYYY-MM-DD): ");
                        String fechaIniciotxt = sc.nextLine();
                        LocalDate fechaInicio = LocalDate.parse(fechaIniciotxt);
                        System.out.println("Fecha de fin (YYYY-MM-DD): ");
                        String fechaFintxt = sc.nextLine();
                        LocalDate fechaFin = LocalDate.parse(fechaFintxt);
                        System.out.println("Ingrese un horario (HH:mm:ss):");
                        String horarioTXT = sc.nextLine();
                        LocalTime horario = LocalTime.parse(horarioTXT);
                        Feria feria = new Feria(descripcion,nombre,fechaInicio,fechaFin,horario,lugar);
                        ferias.add(feria);
                        break;
                    
                    case 3:
                        System.out.println("Ingrese el código de la feria que desea editar: ");
                        int codigoDeFeriaAEditar = sc.nextInt();
                        sc.nextLine();
                        for(Feria f:ferias){
                            if(codigoDeFeriaAEditar == f.getCodigo()){
                                if(f.getFechaInicio().isBefore(LocalDate.now())){
                                    System.out.println("No se pueden realizar acciones después de la fecha de inicio");
                                } else {
                                    System.out.print("Nuevo nombre: ");
                                    String nombre1 = sc.nextLine();
                                    f.setNombre(nombre1);
                                    
                                    System.out.print("Nueva descripción: ");
                                    String descripcion1 = sc.nextLine();
                                    f.setDescripcion(descripcion1);
                                    
                                    System.out.print("Nuevo lugar: ");
                                    String lugar1 = sc.nextLine();
                                    f.setLugar(lugar1);
                                    
                                    System.out.print("Nueva fecha de inicio (YYYY-MM-DD): ");
                                    String inputFechaInicio = sc.nextLine();
                                    LocalDate fechaInicio1 = LocalDate.parse(inputFechaInicio);
                                    f.setFechaInicio(fechaInicio1);
                                    
                                    System.out.print("Nueva fecha de fin (YYYY-MM-DD): ");
                                    String inputFechaFin = sc.nextLine();
                                    LocalDate fechaFin1 = LocalDate.parse(inputFechaFin);
                                    f.setFechaFin(fechaFin1);
                                    
                                    System.out.print("Nuevo horario (HH:mm:ss): ");
                                    String inputHorario = sc.next();
                                    LocalTime horario1 = LocalTime.parse(inputHorario);
                                    f.setHorario(horario1);
                                    
                                    System.out.println("Campos editados exitosamente.");
                                }
                            }
                            
                        }break;
                    
                    case 4:
                        System.out.println("Ingrese el código de la feria: ");
                        int codigoIngresado = sc.nextInt();
                        sc.nextLine();
                        for(Feria f: ferias){
                            if(f.getCodigo() == codigoIngresado){
                                for(Emprendedor e: f.getListaEmprendedores()){
                                    if(e.getStandAsignado() != null){
                                        System.out.println(e);
                                    }
                                }
                            }
                        }break;
                    
                    default: 
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                        break;
                }
            }while(num!=5);
            num=-1;// numero se cambia para que no salga del otro do while 
        }
     }while(num!=5);  
    }
}
