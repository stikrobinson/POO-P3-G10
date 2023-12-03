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
        
        int num;
        do{
        
        Utilitaria.primerMenu();
        
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
                                    if(e.getStandsAsignados() != null){
                                        System.out.println(e);
                                    }
                                }
                            }
                        }break;
                    case 5:
                        break;
                    
                    default: 
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                        break;
                }
            }while(num!=5);
            num=-1;// numero se cambia para que no salga del otro do while 
            break;
        case 2: 
        do{
            System.out.println("1. Registrar emprendedor");
            System.out.println("2. Editar emprendedor");
            System.out.println("3. Regresar");
            
            num = sc.nextInt();
            sc.nextLine();
            switch(num){
                case 1:
                String cedula;
                boolean verificador = false;
                do{
                System.out.println("Ingrese el número de cédula o RUC");
                cedula = sc.nextLine();
                for(Emprendedor emprendedor: Emprendedor.getEmprendedores()){
                  if(emprendedor.getCedula().equals(cedula)){
                    System.out.println("Cédula ya registrada");
                    verificador = true;
                  }
                  else{
                    verificador = false;
                  }
                }
                }while(verificador==true);
                System.out.println("Ingrese el nombre");
                String nombre = sc.nextLine();
                System.out.println("Ingrese el telefono");
                String telefono = sc.nextLine();
                System.out.println("Ingrese el email");
                String email = sc.nextLine();
                System.out.println("Ingrese la dirección");
                String direccion = sc.nextLine();
                System.out.println("Ingrese el sitio web");
                String sitioWeb = sc.nextLine();
                System.out.println("Ingrese el nombre de la persona responsable");
                String responsable = sc.nextLine();
                System.out.println("Ingrese la descripción de los servicios que ofrece");
                String descripcion = sc.nextLine();
                System.out.println("Nombres en cada red social que maneja");
                Emprendedor emprender = new Emprendedor(cedula, nombre, telefono, email, direccion, sitioWeb, responsable, descripcion);
                Emprendedor.getEmprendedores().add(emprender);
                String respuesta;
                do{                
                System.out.println("Ingrese su red social: Twitter, Facebook, Instagram, YouTube, TikTok, LinkedIn y Pinterest");
                String redSocial = sc.nextLine().toUpperCase();
                try {
                RedSocial r = RedSocial.valueOf(redSocial);
                System.out.println("Ingrese el nombre de la cuenta");
                String usuario = sc.nextLine();
                CuentaRedSocial cuentaRed = new CuentaRedSocial(usuario,r);
                emprender.getListaRedesSociales().add(cuentaRed);
                } catch (IllegalArgumentException except) {
                System.out.println("Opción no válida");
                }
                System.out.println("Si quiere agregar otra red social, escriba Y");
                respuesta = sc.nextLine();
                }while(respuesta.equals("Y"));
                break;
                case 2:
                System.out.println("2");
                break;
                case 3:
                break;
                default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                break;
            }
        }while(num!=3);
        num = -1;
        
        case 3:
            break;
        case 4:
            System.out.println("Ingrese el código de la feria: ");
            int codigoFeriaIngresado = sc.nextInt();
            
            
            for(Feria f: ferias){
                if(codigoFeriaIngresado == f.getCodigo()){
                    System.out.println("Distribución de Stands:");
                    System.out.println("Sección 1: ");
                    for(Stand s: f.getStands()){
                        if(s.getLetra() == 'A'){
                            if(s.getOcupadoPor() == null)
                            System.out.println("[" + s + f.getStands().indexOf(s)+ 1 + "]");
                            else{
                                System.out.println("[" + s + f.getStands().indexOf(s)+ 1 + "*"+ "]");
                            }
                     
                    }
                }   System.out.println("Sección 2:");
                    for(Stand s: f.getStands()){
                        if(s.getLetra() == 'B'){
                            if(s.getOcupadoPor() == null)
                                System.out.println("[" + s + f.getStands().indexOf(s)+ 1 + "]");
                            else{
                                System.out.println("[" + s + f.getStands().indexOf(s)+ 1 + "*"+ "]");
                            }
                    }   
   
                }   System.out.println("Sección 3:");
                    for(Stand s: f.getStands()){
                        if(s.getLetra() == 'C'){
                            if(s.getOcupadoPor() == null)
                            System.out.println("[" + s + f.getStands().indexOf(s)+ 1 + "]");
                            else{
                                System.out.println("[" + s + f.getStands().indexOf(s)+ 1 + "*"+ "]");
                            }
                        }
                }   System.out.println("Sección 4:");
                    for(Stand s: f.getStands()){
                        if(s.getLetra() == 'D'){
                            if(s.getOcupadoPor() == null)
                            System.out.println("[" + s + f.getStands().indexOf(s)+ 1 + "]");
                            else{
                                System.out.println("[" + s + f.getStands().indexOf(s)+ 1 + "*"+ "]");
                            }
                        }
                }
                    
                    
                    
                    
                    
                    
                } 
            
            }
            
             System.out.println("1. Reservar Stand");
             System.out.println("2. Mostrar información Stand");
             System.out.println("3. Regresar");
             
             int opcionElegida = sc.nextInt();
             
             if(opcionElegida == 1){
                 System.out.println("Ingrese el código del stand que desea reservar: ");
                 int codigoStandAReservar = sc.nextInt();
                 for(Feria f: ferias){
                     for(Stand s: f.getStands()){
                      if(s.getCodigoStand() == codigoStandAReservar){   
                        if(s.getOcupadoPor() != null){
                          System.out.println("Lo sentimos, este stand está ocupado");
                        }else{
                         System.out.println("Ingrese el código del emprendedor o auspiciante:");
                         int codigoIngresado = sc.nextInt();
                         for(Emprendedor e: f.getListaEmprendedores()){
                          if(e.getCodigo() == codigoIngresado){
                              if(e.getStandsAsignados().size() <= 2){
                                  s.setOcupadoPor(e);
                                  e.getStandsAsignados().add(s);
                                  
                                  
                              }
                              
                          }
                        }for(AuspicianteEnFeria a: f.getListaAuspiciantes()){
                          if(a.getAuspiciante().getCodigo() == codigoIngresado){
                              if(a.getAuspiciante().getStandsAsignados().size() < 1)
                                s.setOcupadoPor(a.getAuspiciante());
                          }
                        }
                          System.out.println("Distribución de Stands:");
                    System.out.println("Sección 1: ");
                    for(Stand s1: f.getStands()){
                        if(s.getLetra() == 'A'){
                            if(s1.getOcupadoPor() == null)
                            System.out.println("[" + s1 + f.getStands().indexOf(s1)+ 1 + "]");
                            else{
                                System.out.println("[" + s1 + f.getStands().indexOf(s1)+ 1 + "*"+ "]");
                            }
                     
                    }
                }   System.out.println("Sección 2:");
                    for(Stand s1: f.getStands()){
                        if(s1.getLetra() == 'B'){
                            if(s1.getOcupadoPor() == null)
                                System.out.println("[" + s1 + f.getStands().indexOf(s1)+ 1 + "]");
                            else{
                                System.out.println("[" + s1 + f.getStands().indexOf(s1)+ 1 + "*"+ "]");
                            }
                    }   
   
                }   System.out.println("Sección 3:");
                    for(Stand s1: f.getStands()){
                        if(s1.getLetra() == 'C'){
                            if(s1.getOcupadoPor() == null)
                            System.out.println("[" + s1 + f.getStands().indexOf(s1)+ 1 + "]");
                            else{
                                System.out.println("[" + s1 + f.getStands().indexOf(s1)+ 1 + "*"+ "]");
                            }
                        }
                }   System.out.println("Sección 4:");
                    for(Stand s1: f.getStands()){
                        if(s1.getLetra() == 'D'){
                            if(s1.getOcupadoPor() == null)
                            System.out.println("[" + s1 + f.getStands().indexOf(s1)+ 1 + "]");
                            else{
                                System.out.println("[" + s1 + f.getStands().indexOf(s1)+ 1 + "*"+ "]");
                            }
                        }
                }
                        }
                     } 
                    }
                      
                 }
             }else if(opcionElegida == 2){
                 System.out.println("Ingrese el código del stand que desea visualizar: ");
                 int codigoAVisualizar = sc.nextInt();
                 for(Feria f: ferias){
                     for(Stand s: f.getStands()){
                         if(s.getCodigoStand() == codigoAVisualizar){
                             System.out.println("" + s.getCodigoStand()+s.getFechaAsignacion() + s.getOcupadoPor());
                         }
                     }
                 }
             }
   }
  }while(num!=5);   
 }
}
