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
        
        LocalDate fechaInicioEjemplo = LocalDate.of(2023, 1, 1);
        LocalDate fechaFinEjemplo = LocalDate.of(2023, 12, 31);
        LocalTime horaEjemplo = LocalTime.of(12, 30, 0);
        
        Feria feriaPrueba = new Feria("Esta es una feria de prueba", "Feria de Prueba", fechaInicioEjemplo, fechaFinEjemplo, horaEjemplo, "Guayaquil");
        
        
        
        
        
        Auspiciante auspicianteP = new Auspiciante("0914389777", "0939770499", "auspiciante@gmail.com", "Calle A y B Casa 1", "google.com", "Juan", "Marcos", SectorCubierto.ALIMENTACION);
        AuspicianteEnFeria af = new AuspicianteEnFeria(auspicianteP);
        
        
        Emprendedor emprendedor1 = new Emprendedor("123456", "555-1234", "correo@ejemplo.com", "Calle Principal 123", "www.miemprendimiento.com", "Juan Pérez", "Responsable1", "Descripción1");
        Emprendedor emprendedor2 = new Emprendedor("789012", "555-5678", "otrocorreo@ejemplo.com", "Avenida Secundaria 456", "www.otroemprendimiento.com", "Ana López", "Responsable2", "Descripción2");
        Emprendedor emprendedor3 = new Emprendedor("345678", "555-4321", "correo3@ejemplo.com", "Calle Secundaria 789", "www.terceremprendimiento.com", "Roberto Gómez", "Responsable3", "Descripción3");
        Emprendedor emprendedor4 = new Emprendedor("901234", "555-8765", "correo4@ejemplo.com", "Avenida Principal 012", "www.cuartoemprendimiento.com", "Laura Martínez", "Responsable4", "Descripción4");
        
        
        
        feriaPrueba.getListaAuspiciantes().add(af);
        feriaPrueba.getListaEmprendedores().add(emprendedor1);
        feriaPrueba.getListaEmprendedores().add(emprendedor2);
        feriaPrueba.getListaEmprendedores().add(emprendedor3);
        feriaPrueba.getListaEmprendedores().add(emprendedor4);
        
        Stand stand1 = new Stand(0,SectorCubierto.ALIMENTACION, fechaInicioEjemplo, emprendedor1, 'A' );
        Stand stand2 = new Stand(1,SectorCubierto.EDUCACION, fechaInicioEjemplo, emprendedor2, 'B' );
        Stand stand3 = new Stand(2,SectorCubierto.SALUD, fechaInicioEjemplo, emprendedor3, 'C' );
        Stand stand4 = new Stand(3,SectorCubierto.VESTIMENTA, fechaInicioEjemplo, emprendedor4, 'D' );
        
        
        
        
        feriaPrueba.getStands().add(stand1);
        feriaPrueba.getStands().add(stand2);
        feriaPrueba.getStands().add(stand3);
        feriaPrueba.getStands().add(stand4);
        
        ferias.add(feriaPrueba);
        
        
        int num;
        
        ArrayList <Auspiciante> auspiciantes=new ArrayList<>();
        ArrayList <AuspicianteEnFeria> auspiciantesenFeria=new ArrayList<>();
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
            if(Emprendedor.getEmprendedores().size()>0){
              System.out.println("\nListado de emprendedores:");
              for (Emprendedor e: Emprendedor.getEmprendedores()){
                  System.out.println(e.mostrarInfoBasica()+"\n");
              }
            }
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
                }while(verificador || (cedula.equals("")));
                String nombre;
                do{
                System.out.println("Ingrese el nombre");
                nombre = sc.nextLine();
                }while(nombre.equals(""));
                String telefono;
                do{
                System.out.println("Ingrese el telefono");
                telefono = sc.nextLine();
                }while(telefono.equals(""));
                String email;
                do{
                System.out.println("Ingrese el email");
                email = sc.nextLine();
                }while(email.equals(""));
                System.out.println("Ingrese la dirección");
                String direccion = sc.nextLine();
                System.out.println("Ingrese el sitio web");
                String sitioWeb = sc.nextLine();
                String responsable;
                do{
                System.out.println("Ingrese el nombre de la persona responsable");
                responsable = sc.nextLine();
                }while(responsable.equals(""));
                String descripcion;
                do{
                System.out.println("Ingrese la descripción de los servicios que ofrece");
                descripcion = sc.nextLine();
                }while(descripcion.equals(""));
                System.out.println("Nombres en cada red social que maneja");
                Emprendedor emprender = new Emprendedor(cedula, telefono, email, direccion, sitioWeb, nombre, responsable, descripcion);
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
                respuesta = "";
                if(emprender.getListaRedesSociales().size()>0){
                System.out.println("Si quiere agregar otra red social, escriba Y");
                respuesta = sc.nextLine();
                }
                }while(respuesta.equals("Y") || emprender.getListaRedesSociales().size()==0);
                break;
                case 2:
                verificador = true;
                System.out.println("Ingrese la cédula o el RUC del emprendedor a editar");
                cedula = sc.nextLine();
                for(Emprendedor emp: Emprendedor.getEmprendedores()){
                  if(emp.getCedula().equals(cedula)){
                    verificador = false;
                    System.out.println(emp.mostrarInfo());
                    System.out.println("Indique el campo a cambiar, no se puede cambiar la cédula");
                    String campo = sc.nextLine().toUpperCase();
                    switch(campo){
                      case "NOMBRE DEL EMPRENDIMIENTO":
                        System.out.println("Ingrese el nuevo nombre");
                        String cambio = sc.nextLine();  
                        emp.setNombreEmprendimiento(cambio);
                        break;
                      case "RESPONSABLE":
                        System.out.println("Ingrese el nuevo responsable");
                        cambio = sc.nextLine();
                        emp.setNombre_responsable(cambio);
                        break;
                      case "TELEFONO":
                        System.out.println("Ingrese el nuevo teléfono");
                        cambio = sc.nextLine();
                        emp.setTelefono(cambio);
                        break;
                      case "CEDULA":
                        System.out.println("Ingrese la nueva cédula o RUC");
                        cambio = sc.nextLine();
                        emp.setCedula(cambio);
                        break;
                      case "EMAIL":
                        System.out.println("Ingrese el nuevo email");
                        cambio = sc.nextLine();
                        emp.setEmail(cambio);
                        break;
                      case "DIRECCION":
                        System.out.println("Ingrese la nueva dirección");
                        cambio = sc.nextLine();
                        emp.setDireccion(cambio);
                        break;
                      case "SITIO WEB":
                        System.out.println("Ingrese el nuevo sitio web");
                        cambio = sc.nextLine();
                        emp.setSitio_web(cambio);
                        break;
                      case "DESCRIPCION":
                        System.out.println("Ingrese la nueva descripción");
                        cambio = sc.nextLine();
                        break;
                      case "REDES SOCIALES":
                        System.out.println("Escribe borrar para eliminar una cuenta o añadir para ingresar una nueva cuenta");
                        cambio = sc.nextLine().toUpperCase();
                        int contador = 0;
                        if(cambio.equals("AÑADIR")){
                          do{                
                          System.out.println("Ingrese su red social: Twitter, Facebook, Instagram, YouTube, TikTok, LinkedIn y Pinterest");
                          String redSocial = sc.nextLine().toUpperCase();
                          try {
                          RedSocial r = RedSocial.valueOf(redSocial);
                          System.out.println("Ingrese el nombre de la cuenta");
                          String usuario = sc.nextLine();
                          CuentaRedSocial cuentaRedSocial = new CuentaRedSocial(usuario,r);
                          emp.getListaRedesSociales().add(cuentaRedSocial);
                          } catch (IllegalArgumentException except) {
                          System.out.println("Opción no válida");
                          }
                          System.out.println("Si quiere agregar otra red social, escriba Y");
                          respuesta = sc.nextLine();
                          }while(respuesta.equals("Y"));
                        }
                        if(cambio.equals("BORRAR")){
                          for(CuentaRedSocial c: emp.getListaRedesSociales()){
                            System.out.println(contador + ". " + c.getRedSocial() + ":" + c.getCuenta());
                          }
                          System.out.println("Ingresar el número de la cuenta a borrar");
                          int numCuenta = sc.nextInt();
                          sc.nextLine();
                          emp.getListaRedesSociales().remove(numCuenta);
                        }
                        break;
                        default:
                        System.out.println("Campo inválido. Intentelo de nuevo.");
                        break;
                    }
                  }
                }
                if(verificador){
                  System.out.println("No se encontró al emprendedor.");
                }
                break;
                case 3:
                break;
                default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                break;
            }
        }while(num!=3);
        num = -1;
        break;
        
        case 3:
        do{
            System.out.println("1. Registrar auspiciante");
            System.out.println("2. Editar auspiciante");
            System.out.println("3. Asignar auspiciante a feria");
            System.out.println("4. Regresar");

            num = sc.nextInt();
            sc.nextLine();
            switch (num) {
             case 1:
                Boolean verificador=false;
                String cedula;
                do{
                System.out.println("Ingrese numero de cedula o RUC");
                cedula = sc.nextLine();
                for(Emprendedor emprendedor: Emprendedor.getEmprendedores()){
                  if(emprendedor.getCedula().equals(cedula)){
                    System.out.println("Cédula o RUC ya registrada");
                    verificador = true;
                  }
                  else{
                    verificador = false;
                  }
                }
                }while(verificador==true);
                System.out.println("Ingrese nombre");
                String nombre= sc.nextLine();
                System.out.println("Ingrese nombre de persona responsable");
                String nombre_re= sc.nextLine();
                System.out.println("Ingrese un numero de telefono");
                String numero=sc.nextLine();
                System.out.println("Ingrese su email");
                String email=sc.nextLine();
                System.out.println("Ingrese su sitio web");
                String sitioweb=sc.nextLine();
                System.out.println("Ingrese la dirección");
                String direccion = sc.nextLine();
                System.out.println("Ingrese el sector cubierto");
                String sector=sc.nextLine().toUpperCase();
                SectorCubierto s=SectorCubierto.valueOf(sector);
                Auspiciante auspiciante=new Auspiciante(cedula,numero,email,direccion,sitioweb,nombre_re,nombre,s);
                String respuesta;
                do{                
                System.out.println("Ingrese su red social: Twitter, Facebook, Instagram, YouTube, TikTok, LinkedIn y Pinterest");
                String redSocial = sc.nextLine().toUpperCase();
                try {
                RedSocial r = RedSocial.valueOf(redSocial);
                System.out.println("Ingrese el nombre de la cuenta");
                String usuario = sc.nextLine();
                CuentaRedSocial cuentaRed = new CuentaRedSocial(usuario,r);
                auspiciante.getListaRedesSociales().add(cuentaRed);
                } catch (IllegalArgumentException except) {
                System.out.println("Opción no válida");
                }
                System.out.println("Si quiere agregar otra red social, escriba Y");
                respuesta = sc.nextLine();
                }while(respuesta.equals("Y"));
                auspiciantes.add(auspiciante);
                break;
            case 2:
                System.out.println("Ingrese el numero de cedula del usuario que desea editar");
                String cedu=sc.nextLine();
                
                for (Auspiciante a:auspiciantes){
                    if (a.getCedula().equals(cedu)){
                        String r;
                        do {
                          a.editar();
                          System.out.println("Si desea seguir editando ingrese 'Y' ");
                          r=sc.nextLine().toUpperCase();  
                        } while (r.equals("Y"));
                        
                    }
                }
                break;
            case 3:
                System.out.println("Ingrese un codigo de feria");
                int cod=sc.nextInt();
                sc.nextLine();
                System.out.println("Ingrese un numero de cedula o RUC");
                String ced= sc.nextLine();
                boolean verificador_1=false;
                boolean verificador_2=false;
                int in_1=0;
                int in_2=0;
                for (Feria f:ferias){
                    if (f.getCodigo()==(cod)){
                        verificador_1=true;
                        in_1=ferias.indexOf(f);
                    }
                }
                for(Auspiciante a: auspiciantes){
                    if(a.getCedula().equals(ced)){
                        verificador_2=true;
                        in_2=auspiciantes.indexOf(a);
                    }
                }
                if(verificador_1&&verificador_2){
                    System.out.println("Ingrese descripcion");//descripcion del auspicio?
                    String desc=sc.nextLine();
                    System.out.println("Incluye stand en la feria:(Si/No)");
                    String r=sc.nextLine().toUpperCase();

                    if (r.equals("SI")){//Falta
                       if (r.equals("SI")){
                        Feria f=ferias.get(in_1);
                    AuspicianteEnFeria a=new AuspicianteEnFeria(auspiciantes.get(in_2),desc,true);
                    f.getListaAuspiciantes().add(a);}
                    

                                        else{

                        Feria f=ferias.get(in_1);
                    AuspicianteEnFeria a=new AuspicianteEnFeria(auspiciantes.get(in_2),desc,false);
                    f.getListaAuspiciantes().add(a);
                    }

                   }    
                }
                break;
            case 4:
                break;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                break;
        }
        }while(num!=4);
           num = -1;
           break;
        
         case 4:
            int opcionElegida;
            System.out.println("Ingrese el código de la feria: ");
            int codigoFeriaIngresado = sc.nextInt();
            
            do{
            for(Feria f: ferias){
                if(codigoFeriaIngresado == f.getCodigo()){
                    System.out.println("Distribución de Stands:");
                    System.out.println("Sección 1: ");
                    for(Stand s0: f.getStands()){
                        if(s0.getLetra() == 'A'){
                            if(s0.getOcupadoPor() == null)
                            System.out.println("[" + s0 + f.getStands().indexOf(s0)+ 1 + "]");
                            else{
                                System.out.println("[" + s0 + f.getStands().indexOf(s0)+ 1 + "*"+ "]");
                            }
                     
                    }
                }   System.out.println("Sección 2:");
                    for(Stand s0: f.getStands()){
                        if(s0.getLetra() == 'B'){
                            if(s0.getOcupadoPor() == null)
                                System.out.println("[" + s0 + f.getStands().indexOf(s0)+ 1 + "]");
                            else{
                                System.out.println("[" + s0 + f.getStands().indexOf(s0)+ 1 + "*"+ "]");
                            }
                    }   
   
                }   System.out.println("Sección 3:");
                    for(Stand s0: f.getStands()){
                        if(s0.getLetra() == 'C'){
                            if(s0.getOcupadoPor() == null)
                            System.out.println("[" + s0 + f.getStands().indexOf(s0)+ 1 + "]");
                            else{
                                System.out.println("[" + s0 + f.getStands().indexOf(s0)+ 1 + "*"+ "]");
                            }
                        }
                }   System.out.println("Sección 4:");
                    for(Stand s0: f.getStands()){
                        if(s0.getLetra() == 'D'){
                            if(s0.getOcupadoPor() == null)
                            System.out.println("[" + s0 + f.getStands().indexOf(s0)+ 1 + "]");
                            else{
                                System.out.println("[" + s0 + f.getStands().indexOf(s0)+ 1 + "*"+ "]");
                            }
                        }
                }
                    
                    
                    
                    
                    
                    
                } 
            

            }
            
             System.out.println("1. Reservar Stand");
             System.out.println("2. Mostrar información Stand");
             System.out.println("3. Regresar");
             
             opcionElegida = sc.nextInt();
             
             if(opcionElegida == 1){
                 System.out.println("Ingrese el código del stand que desea reservar: ");
                 int codigoStandAReservar = sc.nextInt();
                 for(Feria f: ferias){
                     for(Stand s3: f.getStands()){
                      if(s3.getCodigoStand() == codigoStandAReservar){   
                        if(s3.getOcupadoPor() != null){
                          System.out.println("Lo sentimos, este stand está ocupado");
                        }else{
                         System.out.println("Ingrese el código del emprendedor o auspiciante:");
                         int codigoIngresado = sc.nextInt();
                         for(Emprendedor e: f.getListaEmprendedores()){
                          if(e.getCodigo() == codigoIngresado){
                              if(e.getStandsAsignados().size() <= 2){
                                  s3.setOcupadoPor(e);
                                  e.getStandsAsignados().add(s3);
                                  
                                  
                              }
                              
                          }
                        }for(AuspicianteEnFeria a: f.getListaAuspiciantes()){
                          if(a.getAuspiciante().getCodigo() == codigoIngresado){
                              if(a.getAuspiciante().getStandsAsignados().size() < 1)
                                s3.setOcupadoPor(a.getAuspiciante());
                          }
                        }
                          System.out.println("Distribución de Stands:");
                    System.out.println("Sección 1: ");
                    for(Stand s1: f.getStands()){
                        if(s1.getLetra() == 'A'){
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
                     for(Stand s4: f.getStands()){
                         if(s4.getCodigoStand() == codigoAVisualizar){
                             System.out.println("" + s4.getCodigoStand()+s4.getFechaAsignacion() + s4.getOcupadoPor());
                         }
                     }
                 }
             }
             else if (opcionElegida>3){
             System.out.println("Opción no válida. Inténtalo de nuevo.");
             }
             
    }while(opcionElegida!=3);
     num = -1;
   }
  }while(num!=5);
 }
}    
